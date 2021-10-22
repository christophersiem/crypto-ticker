FROM openjdk:17

ENV ENVIRONMENT=prod

MAINTAINER Christopher Siem <christopher.siem@posteo.de>

ADD backend/target/app.jar app.jar

CMD [ "sh", "-c", "java -Dserver.port=$PORT -jar /app.jar" ]