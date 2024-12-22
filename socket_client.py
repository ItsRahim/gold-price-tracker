import argparse

parser = argparse.ArgumentParser(description="Connects client to server via a WebSocket")

# Argument for host
parser.add_argument("-host", metavar="host", required=True, help="The hostname of the socket server")

# Argument for port
parser.add_argument("-port", metavar="port", required=True, type=int, help="The port of the socket server")

# Parsing the arguments
args = parser.parse_args()

# Accessing the arguments
host = args.host
port = args.port

print(f"Connecting to {host} on port {port}...")
