# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Build the project
RUN ./mvnw clean install

# Run the Spring Boot application
CMD ["java", "-jar", "target/number-storage-0.0.1-SNAPSHOT.jar"]
