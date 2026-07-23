FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY target/demo2-0.0.1-SNAPSHOT.jar  app1.jar

EXPOSE 8080
 

ENTRYPOINT [ "java","-jar","app1.jar" ,"--spring.profiles.active=docker"]

