FROM openjdk:8u131-jdk-alpine
EXPOSE 8083
COPY ./target/checklist-service.jar checklist-service.jar 
ENTRYPOINT ["java","-jar","/checklist-service.jar"]