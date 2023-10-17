FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package

FROM openjdk:17-alpine
COPY --from=build /target/travel_social-0.0.1-SNAPSHOT.jar trave_social.jar

EXPOSE 9999
ENTRYPOINT ["java","-jar","travel_social.jar"]