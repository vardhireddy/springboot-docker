FROM openjdk:8
ADD target/docker-springboot.jar docker-springboot.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","docker-springboot.jar"]
