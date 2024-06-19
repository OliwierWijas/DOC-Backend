#Sets up environment for building the application.
FROM maven:3.9.6-amazoncorretto-17-debian AS build
#Prepares directory for Docker
RUN mkdir -p /app
WORKDIR /app
#Adds project files to Docker image for building.
COPY pom.xml /app
COPY src /app/src
#Builds the application without running tests.
RUN mvn -B package --file pom.xml -DskipTests

#Sets up runtime environment for the application.
FROM openjdk:17
#Transfers built application artifact (backend-1.jar) for runtime use.
COPY --from=build /app/target/*jar backend-1.jar
#Specifies the port where the application will listen for incoming requests.
EXPOSE 8080
#Executes the JAR file (backend-1.jar) as the main application process.
ENTRYPOINT ["java", "-jar", "backend-1.jar"]
