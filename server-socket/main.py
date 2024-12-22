import argparse
import logging
from websocket.server import start

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')


def parse_arguments():
    parser = argparse.ArgumentParser(description="Connects client to server via a WebSocket")
    parser.add_argument("-host", metavar="host", required=True, help="The hostname of the socket server")
    parser.add_argument("-port", metavar="port", required=True, type=int, help="The port of the socket server")

    return parser.parse_args()


def main():
    try:
        args = parse_arguments()

        host = args.host
        port = args.port
        start(host, port)
    except Exception as e:
        logging.error(f"Error while starting the server: {e}")
    finally:
        logging.info("Server has stopped.")


if __name__ == "__main__":
    main()
