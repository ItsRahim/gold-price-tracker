#!/bin/bash

CLIENT_DIR="./server-socket"
SERVER_DIR="./price-scraper"

SCRIPT_DIR=$(pwd)
OUTPUT_DIR="$SCRIPT_DIR/socket_output"

PYTHON=$(which python)

echo "Client directory: $CLIENT_DIR"
echo "Server directory: $SERVER_DIR"

# Check if CLIENT_DIR exists
if [ ! -d "$CLIENT_DIR" ]; then
    echo "Client directory does not exist."
fi

# Check if SERVER_DIR exists
if [ ! -d "$SERVER_DIR" ]; then
    echo "Server directory does not exist."
fi

# Check if Python is installed, if not install it
if [ -z "$PYTHON" ]; then
    echo "Python not found. Installing Python 3.11 now..."

    if [ -x "$(command -v apt-get)" ]; then
        sudo apt-get update
        sudo apt-get install -y software-properties-common
        sudo add-apt-repository ppa:deadsnakes/ppa
        sudo apt-get update
        sudo apt-get install -y python3.11
    elif [ -x "$(command -v brew)" ]; then
        brew install python@3.11
    elif [ -x "$(command -v winget)" ]; then
        winget install Python.Python.3.11
    else
        echo "Could not detect package manager. Please install Python 3.11 manually."
        exit 1
    fi

    PYTHON=$(which python3.11)
    if [ -z "$PYTHON" ]; then
        echo "Python 3.11 installation failed. Please install it manually."
        exit 1
    else
      echo "Python 3.11 installed successfully."
    fi
else
    PYTHON_VERSION=$("$PYTHON" --version 2>&1)
    echo "Using Python version: $PYTHON_VERSION. Proceeding with socket executable generation..."
fi

# Check if pipenv is installed, if not install it
PIPENV=$(which pipenv)

if [ -z "$PIPENV" ]; then
    echo "Pipenv not found. Installing pipenv now..."
    $PYTHON -m pip install --user pipenv
    if [ $? -eq 0 ]; then
        echo "Pipenv installed successfully."
    else
        echo "Pipenv installation failed. Please install it manually."
        exit 1
    fi
else
    echo "Pipenv is already installed."
fi

# Install PyInstaller
echo "Installing PyInstaller..."
$PYTHON -m pip install --user pyinstaller
if [ $? -eq 0 ]; then
    echo "PyInstaller installation failed. Please install it manually."
    exit 1
else
    echo "PyInstaller installed successfully."
fi

# Function to run PyInstaller and move the output to the specified directory
run_pyinstaller() {
    local dir=$1
    local output_name=$2

    if [ -d "$dir" ]; then
        echo "Entering directory: $dir"
        cd "$dir"

        pyinstaller main.py --onefile

        # Ensure the OUTPUT_DIR exists, create it if not
        mkdir -p "$OUTPUT_DIR"

        # Move the executable to the output directory
        mv dist/main "$OUTPUT_DIR/$output_name"

        echo "PyInstaller build for $dir completed and renamed to $output_name."

        cd "$SCRIPT_DIR"
    else
        echo "Directory $dir not found."
    fi
}

# Run pyinstaller for each directory
run_pyinstaller "$CLIENT_DIR" "client"
run_pyinstaller "$SERVER_DIR" "server"

echo "Python socket executables generated successfully."
