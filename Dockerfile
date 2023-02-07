FROM openjdk:11-jdk-slim
EXPOSE 8080
ADD target/testBackend-0.0.1-SNAPSHOT.jar testBackend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/testBackend-0.0.1-SNAPSHOT.jar"]