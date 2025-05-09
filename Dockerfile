#FROM eclipse-temurin:17-jdk-alpine
#WORKDIR /app
#COPY target/LearningSpringBoot-0.0.1-SNAPSHOT.jar LearningSpringBoot-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#CMD ["java","-jar","LearningSpringBoot-0.0.1-SNAPSHOT.jar"]
# Use a smaller base image for the final image
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/LearningSpringBoot-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-Xmx256m", "-Xms128m", "-jar", "app.jar"]