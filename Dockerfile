FROM amazoncorretto:19
MAINTAINER FACUNDO  
COPY target/PortfolioFR-0.0.1-SNAPSHOT.jar frportfolio-app.jar
ENTRYPOINT ["java", "-jar", "/frportfolio-app.jar"]
EXPOSE 8080