FROM openjdk:8u212-jre-alpine3.9

#Install curl and jq
RUN apk add curl jq

WORKDIR /usr/project/docker

ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

ADD SearchText-testng.xml  SearchText-testng.xml
ADD Book-Flight-Module.xml Book-Flight-Module.xml
ADD HealthCheck.sh	    HealthCheck.sh

ENTRYPOINT sh HealthCheck.sh
