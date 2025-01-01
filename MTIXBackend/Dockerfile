## Use an official Java runtime as the base image
#FROM openjdk:17-jdk-slim
#
## Set the working directory
#WORKDIR /app
#
## Copy the Spring Boot JAR file into the container
#COPY target/MTIXBackend-0.0.1-SNAPSHOT.jar app.jar
#
## Expose the application port
#EXPOSE 9090
#
## Run the Spring Boot application
#ENTRYPOINT ["java", "-jar", "app.jar"]

# Build stage
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only necessary files for dependency resolution
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the project files and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Package stage
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/MTIXBackend-0.0.1-SNAPSHOT.jar app.jar

# Expose the application's port
EXPOSE 9090

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

