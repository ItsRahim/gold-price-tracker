import argparse
import logging

from websocket.client import SocketClient
from config.config import DISCONNECT_MESSAGE

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

MODES = ['test', 'dev', 'prod']

def parse_arguments():
    parser = argparse.ArgumentParser(description="Connects client to server via a WebSocket")
    parser.add_argument("-host", metavar="host", required=True, help="The hostname of the socket server")
    parser.add_argument("-port", metavar="port", required=True, type=int, help="The port of the socket server")
    parser.add_argument("-mode", metavar="mode", required=True, choices=MODES, help="The mode of the websocket server")

    return parser.parse_args()


def main():
    args = parse_arguments()

    host = args.host
    port = args.port
    mode = args.mode

    logger.info(f"Connecting to {host} on port {port} in {mode} mode...")

    socket_client = SocketClient.get_instance()
    socket_client.connect(host, port)

    if mode == 'test':
        while True:
            message = input("Enter message to send (or 'exit' to close): ")

            if message.lower() == 'exit':
                logger.info("Exiting connection.")
                socket_client.send_message(DISCONNECT_MESSAGE)
                socket_client.socket.close()
                break
            else:
                socket_client.send_message(message)

    else:
        logger.info(f"Message sending is disabled in {mode} mode.")
    socket_client.socket.close()


if __name__ == "__main__":
    main()