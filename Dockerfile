# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper files (mvnw and mvnw.cmd) and the pom.xml file
COPY mvnw .
COPY mvnw.cmd .
COPY pom.xml .

# Copy the project source
COPY src ./src

# Build the application
RUN ./mvnw clean package

# Run the Spring Boot application
CMD ["java", "-jar", "target/number-storage-0.0.1-SNAPSHOT.jar"]
