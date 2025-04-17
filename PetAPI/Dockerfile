# Use Maven image with JDK 17
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the project and run tests
RUN mvn clean test
