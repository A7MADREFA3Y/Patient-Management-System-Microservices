# Builder stage: Use Eclipse Temurin JDK 24 Alpine with Gradle Wrapper
FROM eclipse-temurin:24-jdk-alpine AS builder

# Install bash, unzip, curl needed to run Gradle wrapper
RUN apk add --no-cache bash unzip curl

WORKDIR /app

# Copy Gradle wrapper and config files for caching dependencies
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./

# Make gradlew executable
RUN chmod +x ./gradlew

# Download dependencies offline without building
RUN ./gradlew --no-daemon --refresh-dependencies

# Copy source code
COPY src ./src

# Build and package the jar, skip tests to speed up build
RUN ./gradlew clean build -x test

# Runtime stage: Use Eclipse Temurin JDK 24 Alpine runtime
FROM eclipse-temurin:24-jdk-alpine AS runner

WORKDIR /app

# Copy the built jar from builder stage
COPY --from=builder /app/build/libs/*.jar ./app.jar

# Expose your application port
EXPOSE 4000

# Run the jar application
ENTRYPOINT ["java", "-jar", "app.jar"]
