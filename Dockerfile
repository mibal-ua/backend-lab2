FROM eclipse-temurin:21.0.2_13-jre-alpine

WORKDIR /app

COPY target/backend-lab2-2.0-SNAPSHOT.jar app.jar

EXPOSE 8080:8080

CMD ["java", "-jar", "app.jar"]
