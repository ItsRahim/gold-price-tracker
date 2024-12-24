import socket
import threading
import logging
import time
from config.config import DISCONNECT_MESSAGE

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

HEADER = 64
FORMAT = 'utf-8'
HEARTBEAT_INTERVAL = 30

active_connections = []


def broadcast_message(message):
    """
    Sends a message to all connected clients.
    :param message: The message to broadcast.
    """
    logger.info(f"[BROADCAST] Sending message to all clients: {message}")
    for conn in active_connections:
        try:
            conn.send(message.encode(FORMAT))
        except Exception as e:
            logger.warning(f"[BROADCAST ERROR] Failed to send message to a client: {e}")


def handle_client(conn, addr):
    """
    Handles communication with a connected client.
    :param conn: Client socket object.
    :param addr: Client address tuple.
    """
    logger.info(f"[NEW CONNECTION] {addr} connected")
    active_connections.append(conn)
    last_heartbeat = time.time()

    try:
        connected = True
        while connected:
            if time.time() - last_heartbeat > HEARTBEAT_INTERVAL:
                logger.warning(f"[TIMEOUT] No heartbeat from {addr} for {HEARTBEAT_INTERVAL} seconds.")
                break

            conn.settimeout(HEARTBEAT_INTERVAL)
            try:
                msg_length = conn.recv(HEADER).decode(FORMAT)
                if not msg_length:
                    continue

                try:
                    msg_length = int(msg_length)
                except ValueError:
                    logger.warning(f"[INVALID HEADER] Received non-integer header from {addr}")
                    continue

                msg = conn.recv(msg_length).decode(FORMAT)
                logger.info(f"[RECEIVED] From {addr}: {msg}")

                if msg == DISCONNECT_MESSAGE:
                    logger.info(f"[DISCONNECT REQUEST] {addr} is disconnecting.")
                    connected = False
                elif msg == "PING":
                    logger.info(f"[HEARTBEAT] Received heartbeat from {addr}")
                    last_heartbeat = time.time()
                    conn.send("PONG".encode(FORMAT))
                else:
                    pass
            except socket.timeout:
                logger.warning(f"[TIMEOUT] {addr} did not send data in {HEARTBEAT_INTERVAL} seconds.")
                break
    except ConnectionResetError:
        logger.warning(f"[DISCONNECTED] {addr} forcibly closed the connection.")
    except Exception as e:
        logger.error(f"[ERROR] An error occurred with {addr}: {e}")
    finally:
        conn.close()
        active_connections.remove(conn)
        logger.info(f"[CONNECTION CLOSED] {addr} disconnected")


def start(host: str, port: int):
    """
    Starts the server and listens for incoming connections.
    :param host: Server IP address to bind.
    :param port: Server port to bind.
    """
    server_address = (host, port)
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind(server_address)
    sock.listen()
    logger.info(f"[STARTING] Server is listening on {host}:{port}")

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
