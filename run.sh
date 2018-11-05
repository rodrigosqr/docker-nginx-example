#!/bin/bash
echo "DOCKER TOPPER"
DIRETORIO=portal-ferias/portalferias
JARFILE=docker/app/portalferias.jar

if [ ! -d "$DIRETORIO" ]; then
  echo "BAIXANDO E GERANDO BUID DO PROJETO"
  git clone https://github.com/rodrigosqr/portal-ferias.git
  cd $DIRETORIO
  chmod +x mvnw
  ./mvnw clean package -Dmaven.test.skip=true 
fi

if [ ! -f "$JARFILE" ]; then
  echo "COPIANDO JAR PARA O DIRETORIO 'docker/app'"
  cp $DIRETORIO/target/portalferias.jar $JARFILE
fi

sudo docker-compose build
echo "PRONTO"


