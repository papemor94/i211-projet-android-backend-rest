#  Websocket, API REST, JPA (Hibernate)

## General info
Project is created with:
*  version: 1.0
* Date: 01/2021

 ##  Technologies
Simple java applation with

* Websocket 
* Hibernate
* Grizzly
* Jersey

## Some curl command to communicate with the API

curl -X GET  -H "Content-Type: application/JSON" http://localhost:8091/bibliotheque/livres

 # Dockerize 

## Build the multi-stage docker image of the java application 
See Dockerfile
- clean and compile the application inside docker 
- build the jar file with all dependences
- and execute java -jar int the entrypoint

docker build -t rest-image .

## Tag and push the docker image in docker hub

docker image tag iimage_name pcisse200/image_name:tag
docker push  pcisse200/image_name:tag

## Run the java conatiner from the docker hub repository image with mysql

sh script.sh


