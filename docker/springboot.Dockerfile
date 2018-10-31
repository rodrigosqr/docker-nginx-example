FROM openjdk:8-jdk-alpine
MAINTAINER Rodrigo Siqueira <rodrigosiqueira.01@gmail.com>
# VOLUME /tmp
RUN mkdir /home/springboot
COPY /docker/app/ExtensaoSB.jar /home/springboot/app.jar
WORKDIR /home/springboot
EXPOSE 8081
ENTRYPOINT ["java",  "-jar", "app.jar"]