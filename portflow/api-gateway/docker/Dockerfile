ARG ECLIPSE_TEMURIN_JDK_VERSION=25-jdk-alpine

FROM eclipse-temurin:${ECLIPSE_TEMURIN_JDK_VERSION} 
WORKDIR /app
COPY target/api-gateway-1.0-SNAPSHOT.jar app.jar
EXPOSE 9999
CMD [ "java", "-jar","app.jar" ]


