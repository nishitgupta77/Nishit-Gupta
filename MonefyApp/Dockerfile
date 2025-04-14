# Base image with Maven, OpenJDK 17, and Debian (can install tools)
FROM maven:3.8.8-openjdk-17

# Update certs to fix Maven Central SSL issue
RUN apt-get update && apt-get install -y \
    ca-certificates \
    curl \
    unzip \
    android-tools-adb \
    nodejs \
    npm \
    && update-ca-certificates \
    && apt-get clean

# Disable strict SSL for npm (temporary workaround for SSL issues)
RUN npm config set strict-ssl false && npm install -g appium

# Set working directory
WORKDIR /usr/src/app

# Copy project files
COPY . .

# Expose Appium default port
EXPOSE 4723

# Start Appium and run Maven tests
CMD appium & mvn clean test
