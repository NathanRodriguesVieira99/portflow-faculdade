ARG ECLIPSE_TEMURIN_JDK_VERSION=25-jdk-alpine

FROM eclipse-temurin:${ECLIPSE_TEMURIN_JDK_VERSION} 
WORKDIR /app
COPY target/*.jar app.jar
EXPOSE 9999
CMD [ "java", "-jar","app.jar" ]


