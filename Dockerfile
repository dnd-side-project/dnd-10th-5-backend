FROM openjdk:17-jdk

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "app.jar"]
