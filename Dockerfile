FROM eclipse-temurin:21-jdk

RUN useradd -m fiapuser

WORKDIR /app

COPY target/agricultura-inteligente-api-0.0.1-SNAPSHOT.jar app.jar

ENV SPRING_PROFILES_ACTIVE=prod

EXPOSE 8081

USER fiapuser

ENTRYPOINT ["java","-jar","app.jar"]