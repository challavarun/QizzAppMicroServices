FROM openjdk:24

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} QuestionAppService.jar

ENTRYPOINT ["java", "-jar", "/QuestionAppService.jar"]

EXPOSE 8081