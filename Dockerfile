FROM openjdk:21
WORKDIR /opt
COPY *.jar /opt/app.jar
CMD ["java", "-jar", "/opt/app.jar"]


