import logging
from apscheduler.schedulers.background import BackgroundScheduler

from scraper.price import scrape_gold_price

logging.basicConfig(level=logging.INFO, format='%(asctime)s - %(levelname)s - %(message)s')
logger = logging.getLogger(__name__)

scheduler = BackgroundScheduler()


def get_gold_price_job():
    logger.info("Running scheduled task: scrape_gold_price")
    try:
        scrape_gold_price()
        logger.info("Gold price scraped successfully")
    except Exception as e:
        logger.error(f"Failed to scrape gold price: {e}")


def start_scheduler():
    """
    Starts the APScheduler to periodically run tasks.
    """
    try:
        scheduler.add_job(get_gold_price_job, 'interval', minutes=1)
        scheduler.start()
        logger.info("Scheduler started with 'get_gold_price' job")
    except Exception as e:
        logger.error(f"Failed to start the scheduler: {e}")


def stop_scheduler():
    """
    Stops the APScheduler gracefully.
    """
    logger.info("Stopping the scheduler...")
    scheduler.shutdown()
    logger.info("Scheduler stopped.")
