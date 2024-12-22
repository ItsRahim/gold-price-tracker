import socket
import threading
import logging
from config.load_config import Config

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

HEADER = 64
SERVER = Config.get_socket_host()
PORT = Config.get_socket_port()
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
DISCONNECT_MESSAGE = "DISCONNECT"

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
sock.bind(ADDR)


def handle_client(conn, addr):
    logger.info(f"[NEW CONNECTION] {addr} connected")

    try:
        connected = True
        while connected:
            msg_length = conn.recv(HEADER).decode(FORMAT)
            if msg_length:
                msg_length = int(msg_length)
                msg = conn.recv(msg_length).decode(FORMAT)

                if msg == DISCONNECT_MESSAGE:
                    connected = False
                logger.info(f"[RECEIVED] From {addr}: {msg}")

        conn.close()
    except ConnectionResetError:
        logger.warning(f"[DISCONNECTED] {addr} forcibly closed the connection.")
    except Exception as e:
        logger.error(f"[ERROR] An error occurred with {addr}: {e}")
    finally:
        conn.close()
        logger.info(f"[CONNECTION CLOSED] {addr} disconnected")


def start():
    sock.listen()
    logger.info(f"[LISTENING] Server is listening on {ADDR}")

    try:
        while True:
            conn, addr = sock.accept()
            logger.info(f"[ACCEPTED CONNECTION] {addr}")

            thread = threading.Thread(target=handle_client, args=(conn, addr), daemon=True)
            thread.start()

            logger.info(f"[ACTIVE CONNECTIONS] {threading.active_count() - 1}")
    except KeyboardInterrupt:
        logger.info("[SHUTDOWN] Server is shutting down.")
    except Exception as e:
        logger.error(f"[ERROR] Server error: {e}")
    finally:
        sock.close()
        logger.info("[SERVER CLOSED] Server socket closed.")


if __name__ == "__main__":
    start()
