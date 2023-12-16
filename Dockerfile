
FROM openjdk:21
WORKDIR /Epic2Maven
COPY target/Epic2Maven-1.0-SNAPSHOT.jar ./
CMD ["java", "-jar", "Epic2Maven-1.0-SNAPSHOT.jar"]

