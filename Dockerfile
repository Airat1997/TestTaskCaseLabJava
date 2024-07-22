FROM openjdk:17-jdk-alpine
WORKDIR /home
EXPOSE 8080
COPY . .
RUN apk add maven
#ENTRYPOINT ["java","-jar","/home/app.jar"]