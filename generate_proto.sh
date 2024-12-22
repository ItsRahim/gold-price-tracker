#!/bin/bash

PROTO_DIR="./proto"
JAVA_OUT="./proto-messages/src/main/java"
PYTHON_OUT="./price-scraper/proto"

PROTOC=$(which protoc)

if [ -z "$PROTOC" ]; then
    echo "protoc compiler not found. Installing it now..."

    if [ -x "$(command -v apt-get)" ]; then
        sudo apt-get update
        sudo apt-get install -y protobuf-compiler
    elif [ -x "$(command -v brew)" ]; then
        brew install protobuf
    elif [ -x "$(command -v winget)" ]; then
        winget install protobuf
    else
        echo "Could not detect package manager. Please install protoc manually."
        exit 1
    fi

    PROTOC=$(which protoc)
    if [ -z "$PROTOC" ]; then
        echo "protoc installation failed. Please install it manually."
        exit 1
    fi
    echo "protoc installed successfully."
else
  PROTOC_VERSION=$("$PROTOC" --version 2>&1)
  echo "Using protoc version: $PROTOC_VERSION. Proceeding with code generation..."
fi

if [[ "$OSTYPE" == "msys"* || "$OSTYPE" == "cygwin" ]]; then
    PROTO_DIR=$(cygpath -u "$PROTO_DIR")
    JAVA_OUT=$(cygpath -u "$JAVA_OUT")
    PYTHON_OUT=$(cygpath -u "$PYTHON_OUT")
fi

"$PROTOC" --proto_path="$PROTO_DIR" --java_out="$JAVA_OUT" --python_out="$PYTHON_OUT" "$PROTO_DIR"/*.proto

echo "Protobuf Java and Python classes generated successfully."
