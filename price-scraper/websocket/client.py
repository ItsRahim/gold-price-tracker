import socket
import logging
import time
from config.config import DISCONNECT_MESSAGE

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

HEADER = 64
FORMAT = 'utf-8'
TIMEOUT = 10
PING_INTERVAL = 5
PING_TIMEOUT = 10


class SocketClient:
    _instance = None

    def __new__(cls, *args, **kwargs):
        if not cls._instance:
            cls._instance = super(SocketClient, cls).__new__(cls, *args, **kwargs)
            cls._instance.socket = cls.create_socket()
        return cls._instance

    @staticmethod
    def create_socket():
        try:
            client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
            client.settimeout(TIMEOUT)
            logger.info("Socket created successfully.")
            return client
        except socket.error as e:
            logger.error(f"Failed to create socket: {e}")
            raise

    def connect(self, host, port):
        addr = (host, port)
        try:
            self.socket.connect(addr)
            logger.info(f"Connected to server: {host}:{port}")
        except socket.error as e:
            logger.error(f"Connection failed: {e}")
            raise

    def send_message(self, message: str):
        try:
            message = message.encode(FORMAT)
            msg_length = len(message)
            send_length = str(msg_length).encode(FORMAT)
            send_length += b' ' * (HEADER - msg_length)

            self.socket.send(send_length)
            self.socket.send(message)

            if message.decode(FORMAT).upper() != DISCONNECT_MESSAGE:
                logger.info(f"Sent message: {message.decode(FORMAT)}")
        except socket.error as e:
            logger.error(f"Error sending message: {e}")
            self.reconnect()

    def listen_for_messages(self):
        try:
            while True:
                message = self.socket.recv(HEADER).decode(FORMAT)
                if message:
                    logger.info(f"Received message: {message}")
                else:
                    logger.warning("Received empty message. Reconnecting...")
                    self.reconnect()
                    break
        except socket.timeout:
            logger.warning("Timeout while waiting for messages.")
        except socket.error as e:
            logger.error(f"Error receiving message: {e}")
            self.reconnect()

    def send_heartbeat(self):
        try:
            self.send_message("ping")
            logger.info("Sent ping to server.")
        except Exception as e:
            logger.error(f"Error sending ping: {e}")

    def wait_for_heartbeat_response(self):
        try:
            self.socket.settimeout(PING_TIMEOUT)
            message = self.socket.recv(HEADER).decode(FORMAT)
            if message.lower() == "pong":
                logger.info("Received pong from server.")
            else:
                logger.warning(f"Unexpected message: {message}")
        except socket.timeout:
            logger.warning("Timeout waiting for pong.")
        except socket.error as e:
            logger.error(f"Error receiving pong: {e}")

    def start_heartbeat(self):
        while True:
            self.send_heartbeat()
            self.wait_for_heartbeat_response()
            time.sleep(PING_INTERVAL)

    def reconnect(self):
        logger.info("Attempting to reconnect...")
        self.socket.close()
        self.socket = self.create_socket()
        self.connect(self.socket.getpeername()[0], self.socket.getpeername()[1])

    @classmethod
    def get_instance(cls):
        if cls._instance is None:
            cls._instance = SocketClient()
        return cls._instance

    def close(self):
        try:
            self.socket.close()
            logger.info("Socket closed gracefully.")
        except socket.error as e:
            logger.error(f"Error closing socket: {e}")
