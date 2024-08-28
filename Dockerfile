# Use the official OpenJDK image
FROM openjdk:17-jdk-alpine

# Add the application's jar to the container
COPY /target/quickstart.jar /app/quickstart.jar

EXPOSE 8080

# Specify the command to run the jar
ENTRYPOINT ["java", "-jar", "/app/quickstart.jar"]