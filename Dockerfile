FROM openjdk:17
COPY target/backend-1.jar app.jar
EXPOSE 8080
CMD java -jar app.jar