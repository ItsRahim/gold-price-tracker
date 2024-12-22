import socket
import logging

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

HEADER = 64
FORMAT = 'utf-8'
TIMEOUT = 10


def create_socket():
    try:
        client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        client.settimeout(TIMEOUT)
        logger.info("Socket created successfully.")
        return client
    except socket.error as e:
        logger.error(f"Failed to create socket: {e}")
        raise


def connect_to_server(client, server: str, port: int):
    addr = (server, port)
    try:
        client.connect(addr)
        logger.info(f"Connected to server: {server}:{port}")
    except socket.error as e:
        logger.error(f"Connection failed: {e}")
        raise


def start(client, server: str, port: int):
    connect_to_server(client, server, port)


def send_message_to_server(client, message: str):
    message = message.encode(FORMAT)
    msg_length = len(message)
    send_length = str(msg_length).encode(FORMAT)
    send_length += b' ' * (HEADER - msg_length)

    client.send(send_length)
    client.send(message)

    if message.decode(FORMAT).upper() != "DISCONNECT":
        logger.info(f"Sent message: {message.decode(FORMAT)}")
