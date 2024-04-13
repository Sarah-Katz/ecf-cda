FROM maven:3.9.6-eclipse-temurin-17-focal AS build
COPY . .
RUN mvn clean install
RUN mv /target/*.jar /target/api.jar
EXPOSE 8080
CMD ["java", "-jar", "/target/api.jar"]