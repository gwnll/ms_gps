FROM openjdk:8u111-jre-alpine
EXPOSE 8082
COPY build/libs/gps-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]