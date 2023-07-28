FROM amazoncorretto:20-alpine-jdk
WORKDIR /app
COPY target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]