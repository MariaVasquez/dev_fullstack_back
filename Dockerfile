FROM openjdk:11
ADD target/backend_reserved-0.0.1-SNAPSHOT.jar backend_reserved-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "backend_reserved-0.0.1-SNAPSHOT.jar"]