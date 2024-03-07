FROM gradle:8.5 AS build
WORKDIR /app
COPY build.gradle settings.gradle ./
COPY src src
RUN gradle build -x test --no-daemon

FROM openjdk:17-jdk-slim
COPY --from=build /app/build/libs/*.jar /app/build/libs/app.jar
ENTRYPOINT ["java", "-jar", "/app/build/libs/app.jar"]
