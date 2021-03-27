### ETAPA DE CONSTRUCCION ###
FROM maven:3.6.3-openjdk-8-slim AS builder
#3.6.1-jdk-8-alpine
WORKDIR /workspace

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ src/

RUN mvn clean package -Dmaven.test.skip=true


### ETAPA DE EMPAQUETADO (IMAGEN DOCKER FINAL) ###
FROM openjdk:8-jdk-alpine
LABEL maintainer="dreyluisdel92.4@gmail.com"
WORKDIR /workspace


COPY --from=builder /workspace/target/tip*.jar app.jar


EXPOSE 8080
ENTRYPOINT exec java -jar /workspace/app.jar