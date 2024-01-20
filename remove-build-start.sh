#!/bin/bash

# Remove all containers (use with caution)
docker rm -f $(docker ps -aq)

# Remove all images (use with caution)
docker rmi -f $(docker images -aq)

# Build the Docker Compose project
docker-compose build

# Check if the 'docker-compose build' command succeeded
if [ $? -eq 0 ]; then
    # 'docker-compose build' succeeded, so bring up the services
    docker-compose up -d
else
    # 'docker-compose build' failed
    echo "docker-compose build failed. Aborting 'docker-compose up'." >&2
fi