FROM openjdk:17-jdk-alpine
WORKDIR /home
EXPOSE 8080
COPY target/TestTaskCaseLabJava-0.0.1-SNAPSHOT.jar /home/app.jar
ENTRYPOINT ["java","-jar","/home/app.jar"]