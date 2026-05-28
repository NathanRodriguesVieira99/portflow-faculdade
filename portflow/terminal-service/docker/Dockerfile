ARG ECLIPSE_TEMURIN_JDK_VERSION=25-jdk-alpine

FROM eclipse-temurin:${ECLIPSE_TEMURIN_JDK_VERSION} 
WORKDIR /app
COPY target/terminal-service-1.0-SNAPSHOT.jar app.jar
EXPOSE 8082
CMD [ "java", "-jar","app.jar" ]


