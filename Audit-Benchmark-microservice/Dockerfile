FROM openjdk:8u131-jdk-alpine
EXPOSE 9092
COPY ./target/benchmark-service.jar benchmark-service.jar 
ENTRYPOINT ["java","-jar","/benchmark-service.jar"]