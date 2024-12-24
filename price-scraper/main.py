import logging
from config.config import Config
from websocket import server

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

def main():
    try:
        host = Config.get_host()
        port = Config.get_port()
        logger.info(f"[CONFIG LOADED] Host: {host}, Port: {port}")
        server.start(host, port)
    except Exception as e:
        logger.error(f"[ERROR] Failed to start the server: {e}")

if __name__ == "__main__":
    main()
