# Use a base image with Java and Maven installed
FROM eclipse-temurin:21-jdk-jammy

# Expose the port your application runs on
EXPOSE 8080

# Set the working directory in the container
WORKDIR /app

COPY pom.xml .

COPY target/ .

# Copy the application JAR file into the container
COPY target/BankSystem-v1.0.jar .

# Command to run your application
CMD ["java", "-jar", "BankSystem-v1.0.jar"]