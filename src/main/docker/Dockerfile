FROM frolvlad/alpine-oraclejre8:slim
VOLUME /tmp
ADD ioi-external-integration*.jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
