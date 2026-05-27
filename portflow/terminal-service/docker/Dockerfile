ARG ECLIPSE_TEMURIN_JDK_VERSION=25-jdk-alpine

FROM eclipse-temurin:${ECLIPSE_TEMURIN_JDK_VERSION} 
WORKDIR /app
COPY app.jar .
EXPOSE 8082
CMD [ "java", "-jar","app.jar" ]


