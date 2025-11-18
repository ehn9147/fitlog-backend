# Use Java 17 runtime
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project into container
COPY . .

# Make Maven wrapper executable
RUN chmod +x mvnw

# Build the Spring Boot jar
RUN ./mvnw clean package -DskipTests

# Expose backend port
EXPOSE 8080

# Run the built jar
CMD ["sh", "-c", "java -jar target/*.jar"]
