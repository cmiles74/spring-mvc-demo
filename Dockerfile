FROM eclipse-temurin:17
EXPOSE 8080
COPY target/*.jar /spring-mvc-demo.jar
CMD ["java", "-jar", "/spring-mvc-demo.jar"]