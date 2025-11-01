# Start from an official OpenJDK runtime as the base image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY target/recipes-api-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot app runs on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
