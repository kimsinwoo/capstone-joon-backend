FROM openjdk:17-jdk
ARG JAR_FILE=build/libs/*.jar
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]