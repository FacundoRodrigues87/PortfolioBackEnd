FROM amazoncorretto:20-alpine3.14
MAINTAINER FACUNDO  
COPY target/PortfolioFR-0.0.1-SNAPSHOT.jar frportfolio-app.jar
ENTRYPOINT ["java", "-jar", "/frportfolio-app.jar"]
