FROM openjdk:8u131-jdk-alpine
EXPOSE 8084
COPY ./target/severity-service.jar severity-service.jar 
ENTRYPOINT ["java","-jar","/severity-service.jar"]