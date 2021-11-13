FROM gradle:6.9-jdk11-alpine as builder
WORKDIR /usr/src/app
COPY --chown=gradle:gradle . /usr/src/app
WORKDIR /usr/src/app
RUN gradle build


FROM openjdk:11-jre-slim
RUN apt-get update && apt-get install -y tzdata openssl
ENV TZ America/Bogota

EXPOSE 5000

COPY --from=builder /usr/src/app/build/libs/hackaceiba-1.0-SNAPSHOT.jar /app/

WORKDIR /app
#CMD java -jar hackaceiba-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/hackaceiba-1.0-SNAPSHOT.jar"]
