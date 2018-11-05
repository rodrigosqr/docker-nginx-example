#!/bin/bash
echo "DOCKER TOPPER"
JARFILE=../docker/app/portalferias.jar

cd portalferias
chmod +x mvnw
./mvnw clean package -Dmaven.test.skip=true 

echo "COPIANDO JAR PARA O DIRETORIO '../docker/app'"
cp target/portalferias.jar $JARFILE
cd ..

sudo docker-compose build
echo "PRONTO"


