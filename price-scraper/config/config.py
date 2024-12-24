import os
import socket

from dotenv import load_dotenv

load_dotenv()

DISCONNECT_MESSAGE = 'DISCONNECT'

required_vars = ['SOCKET_PORT']
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
