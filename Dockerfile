# syntax=docker/dockerfile:1.7
#
# Multi-stage Dockerfile for Spring Boot (Maven) / Java 21
#
# Build stage
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only files needed to resolve deps first (better cache)
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw mvnw
RUN chmod +x mvnw && ./mvnw -q -DskipTests dependency:go-offline

# Now the sources
COPY src src

# Build the fat jar
RUN ./mvnw -q -DskipTests package

# Runtime stage
FROM eclipse-temurin:21-jre-alpine
ENV TZ=America/Guayaquil     JAVA_OPTS=""
WORKDIR /app

# Copy the built jar
COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

# Pass extra JVM/system props via JAVA_OPTS if you need (e.g., -Xms256m -Xmx512m)
ENTRYPOINT ["/bin/sh","-c","java $JAVA_OPTS -jar /app/app.jar"]
