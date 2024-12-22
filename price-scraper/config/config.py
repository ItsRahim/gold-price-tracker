import os
from dotenv import load_dotenv

load_dotenv()

DISCONNECT_MESSAGE = 'DISCONNECT'

required_vars = []
missing_vars = [var for var in required_vars if not os.getenv(var)]
if missing_vars:
    raise EnvironmentError(f"Missing environment variables: {missing_vars}")

class Config:

    def __init__(self):
        pass
