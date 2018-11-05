FROM openjdk:8-jdk
MAINTAINER Rodrigo Siqueira <rodrigosiqueira.01@gmail.com>
RUN mkdir /home/springboot/
WORKDIR /home/springboot
COPY /docker/app/portalferias.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]
EXPOSE 8081

