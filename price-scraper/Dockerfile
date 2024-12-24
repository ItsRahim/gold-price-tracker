# Use an official Python runtime as a parent image
FROM python:3.11-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Pipfile and Pipfile.lock to the container
COPY Pipfile Pipfile.lock /app/

# Install dependencies
RUN pip install pipenv && pipenv install --system --deploy

# Copy the rest of the application code to the container
COPY . /app

# Specify the entrypoint to run the application with arguments
ENTRYPOINT ["python", "main.py"]
