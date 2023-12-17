
FROM openjdk:21
WORKDIR /Epic2MavenTaxiApp
ADD Taxis.csv /Epic2MavenTaxiApp/
ADD users.csv /Epic2MavenTaxiApp/
COPY target/Epic2Maven-1.0-SNAPSHOT.jar ./
CMD ["java", "-jar", "Epic2Maven-1.0-SNAPSHOT.jar"]

