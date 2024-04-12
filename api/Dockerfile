FROM maven:3.9.6-eclipse-temurin-17-focal AS build
COPY . .
RUN mvn clean install
COPY /target/*.jar /jar/api.jar
EXPOSE 8080
CMD ["java", "-jar", "/jar/api.jar"]