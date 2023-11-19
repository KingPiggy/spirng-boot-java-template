# Use the official OpenJDK base image
FROM eclipse-temurin:17-jdk-jammy

# Copy the packaged Spring Boot application JAR file into the container at /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

EXPOSE 8080

# Run the Spring Boot application when the container launches
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","./app/app.jar"]
