#!/bin/bash
echo "DOCKER TOPPER"
JARFILE=docker/app/portalferias.jar

rm -rf docker/app

cd portalferias
sudo chmod +x mvnw
./mvnw clean package -Dmaven.test.skip=true 

cd ..

mkdir docker/app

echo "COPIANDO JAR PARA O DIRETORIO 'docker/app'"
cp portalferias/target/portalferias.jar $JARFILE

sudo docker-compose build
echo "PRONTO"


