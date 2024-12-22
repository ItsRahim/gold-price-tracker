import argparse
import logging
import sys
from websocket.client import start, create_socket, send_message_to_server

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

DISCONNECT_MESSAGE = "DISCONNECT"


def parse_arguments():
    parser = argparse.ArgumentParser(description="Connects client to server via a WebSocket")
    parser.add_argument("-host", metavar="host", required=True, help="The hostname of the socket server")
    parser.add_argument("-port", metavar="port", required=True, type=int, help="The port of the socket server")

    return parser.parse_args()


def main():
    args = parse_arguments()

    host = args.host
    port = args.port

    logger.info(f"Connecting to {host} on port {port}...")

    try:
        client_socket = create_socket()

        start(client_socket, host, port)

        while True:
            message = input("Enter message to send (or 'exit' to close): ")

            if message.lower() == 'exit':
                logger.info("Exiting connection.")
                send_message_to_server(client_socket, DISCONNECT_MESSAGE)
                client_socket.close()
                break

            send_message_to_server(client_socket, message)

    except Exception as e:
        logger.error(f"Error occurred: {e}")
        sys.exit(1)


if __name__ == "__main__":
    main()
