#!/bin/bash

docker stop $(docker ps -qa)
docker rm $(docker ps -qa)
docker network prune
docker volume prune
docker rmi $(docker image ls -q)
