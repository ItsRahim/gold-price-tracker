import os
from dotenv import load_dotenv

load_dotenv()

required_vars = ['SOCKET_HOST', 'SOCKET_PORT']
missing_vars = [var for var in required_vars if not os.getenv(var)]
if missing_vars:
    raise EnvironmentError(f"Missing environment variables: {missing_vars}")

class Config:

    @staticmethod
    def get_socket_host() -> str:
        return os.getenv('SOCKET_HOST', 'localhost')

    @staticmethod
    def get_socket_port() -> int:
        return int(os.getenv('SOCKET_PORT', 5050))
