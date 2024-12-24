import logging
from config.config import Config
from jobs.cron_jobs import start_scheduler, stop_scheduler
from websocket import server

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)


def main():
    try:
        host = Config.get_host()
        port = Config.get_port()
        logger.info(f"[CONFIG LOADED] Host: {host}, Port: {port}")

        start_scheduler()

        logger.info("Starting WebSocket server...")
        server.start(host, port)
    except Exception as e:
        logger.error(f"[ERROR] Failed to start the server: {e}")
    finally:
        stop_scheduler()


if __name__ == "__main__":
    try:
        main()
    except KeyboardInterrupt:
        logger.info("Application interrupted. Exiting...")
        stop_scheduler()
