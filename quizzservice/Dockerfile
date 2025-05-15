FROM openjdk:24

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} quizservice.jar

ENTRYPOINT ["java", "-jar", "/quizservice.jar"]

EXPOSE 8082