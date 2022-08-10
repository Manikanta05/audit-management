FROM openjdk:8u131-jdk-alpine
EXPOSE 8081
COPY ./target/severity-service.jar severity-service.jar 
ENTRYPOINT ["java","-jar","/severity-service.jar"]