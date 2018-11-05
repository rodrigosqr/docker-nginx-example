#!/bin/bash
echo "DOCKER TOPPER"
JARFILE=docker/app/portalferias.jar

sudo chmod +x portalferias/mvnw
./portalferias/mvnw clean package -Dmaven.test.skip=true 

echo "COPIANDO JAR PARA O DIRETORIO '../docker/app'"
cp portalferias/target/portalferias.jar $JARFILE

sudo docker-compose build
echo "PRONTO"


