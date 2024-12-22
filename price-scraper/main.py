import logging
from websocket.server import start

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')

def main():
    try:
        start()
    except Exception as e:
        logging.error(f"Error while starting the server: {e}")
    finally:
        logging.info("Server has stopped.")

if __name__ == "__main__":
    main()