import os
import socket

from dotenv import load_dotenv

load_dotenv()

DISCONNECT_MESSAGE = 'DISCONNECT'

required_vars = ['SOCKET_PORT', 'DB_HOST', 'DB_PORT', 'DB_NAME', 'DB_USER', 'DB_PASSWORD']
missing_vars = [var for var in required_vars if not os.getenv(var)]
if missing_vars:
    raise EnvironmentError(f"Missing environment variables: {missing_vars}")


class Config:

    @staticmethod
    def get_port() -> int:
        return int(os.getenv('SOCKET_PORT'))

    @staticmethod
    def get_host() -> str:
        return socket.gethostbyname(socket.gethostname())

    @staticmethod
    def get_db_host() -> str:
        return os.getenv('DB_HOST')

    @staticmethod
    def get_db_port() -> int:
        return int(os.getenv('DB_PORT'))

    @staticmethod
    def get_db_name() -> str:
        return os.getenv('DB_NAME')

    @staticmethod
    def get_db_user() -> str:
        return os.getenv('DB_USER')

    @staticmethod
    def get_db_password() -> str:
        return os.getenv('DB_PASSWORD')
