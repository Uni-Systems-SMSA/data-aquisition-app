# Start with a base image that includes OpenJDK 21
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and the src directory to the working directory
COPY pom.xml .
COPY src ./src

# Install Maven
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*

# Build the application using Maven
RUN mvn clean package

# Add the MySQL connector dependency to the Maven project (if not already in the pom.xml)
RUN mvn dependency:get -Dartifact=mysql:mysql-connector-java:LATEST

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java","-jar","target/iot-data-aquisition-0.0.1-SNAPSHOT.jar"]

# Expose the port that the application runs on
EXPOSE 8080