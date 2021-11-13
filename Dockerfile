FROM openjdk:11-jre-slim
RUN apt-get update && apt-get install -y tzdata openssl
ENV TZ America/Bogota

COPY build/libs/hackaceiba-1.0-SNAPSHOT.jar hackaceiba-1.0-SNAPSHOT.jar

CMD java -jar hackaceiba-1.0-SNAPSHOT.jar
