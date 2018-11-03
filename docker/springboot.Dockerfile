FROM openjdk:8-jdk-alpine
MAINTAINER Rodrigo Siqueira <rodrigosiqueira.01@gmail.com>
RUN mkdir /home/springboot
RUN apt-get update && \
	apt-get install -y git;
WORKDIR /home/springboot
RUN git clone https://github.com/rodrigosqr/portal-ferias.git && \
    cd portal-ferias/portalferias && \
    ./mvnw clean package;
# COPY /docker/app/ExtensaoSB.jar /home/springboot/app.jar
EXPOSE 8081
ENTRYPOINT ["java",  "-jar", "portal-ferias/portalferias/target/portalferias.jar"]