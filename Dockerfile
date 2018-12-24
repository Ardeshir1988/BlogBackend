FROM java:8-jre-alpine
EXPOSE 8080
LABEL maintainer=ardeshir.ahouri@gmail.com
VOLUME /tmp
ADD /target/blog-backend.jar blog-backend.jar
ENTRYPOINT ["java","-jar","blog-backend.jar"]