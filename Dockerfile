# Use Amazon Corretto 17 JDK
FROM amazoncorretto:17

WORKDIR /app

# Copy the Maven-built jar
COPY target/*.jar app.jar

# Expose application port (adjust if needed)
EXPOSE 8084

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
