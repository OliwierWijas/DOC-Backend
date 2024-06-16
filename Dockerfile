FROM maven:3.9.6-amazoncorretto-17-debian AS build
RUN mkdir -p /app
WORKDIR /app
COPY pom.xml /app
COPY src /app/src
RUN mvn -B package --file pom.xml -DskipTests

FROM openjdk:17
COPY --from=build /app/target/*jar backend-1.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "backend-1.jar"]
