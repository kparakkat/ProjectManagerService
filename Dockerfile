FROM maven:3.6.1-jdk-8
EXPOSE 9092
ADD /target/ProjectManagerService-0.0.1.jar .
CMD ["java","-Dspring.profiles.active=container","-jar","ProjectManagerService-0.0.1.jar"]