FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /api
COPY . .

FROM openjdk:17.0.2-slim
RUN mkdir /api
COPY --from=build /api/target/api-1.0.0.jar /api/api.jar
WORKDIR /api
EXPOSE 8080
CMD ["java", "-jar", "/api/api.jar"]