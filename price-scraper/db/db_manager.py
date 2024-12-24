from contextlib import contextmanager

from sqlalchemy import create_engine, text
from sqlalchemy.exc import SQLAlchemyError
from sqlalchemy.orm import sessionmaker

from config.config import Config


class DatabaseManager:

    def __init__(self):
        dbname = Config.get_db_name()
        host = Config.get_db_host()
        port = Config.get_db_port()
        user = Config.get_db_user()
        password = Config.get_db_password()

        connection_url = f'postgresql://{user}:{password}@{host}:{port}/{dbname}'

        self.engine = create_engine(connection_url, pool_size=10, max_overflow=20)
        self.Session = sessionmaker(bind=self.engine)

    def execute_query(self, query, params=None):
        try:
            with self.engine.connect() as conn:
                result = conn.execute(text(query), params)
                return result.fetchall()
        except SQLAlchemyError as e:
            log.error(f"Error executing query: {query}. Error: {e}")
            raise

    @contextmanager
    def session_scope(self):
        session = self.Session()
        try:
            yield session
            session.commit()
        except Exception as e:
            session.rollback()
            log.error(f"Error during session operation: {e}")
            raise
        finally:
            session.close()

    def close_connection(self):
        self.engine.dispose()