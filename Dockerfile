FROM openjdk:8
ADD target/pix-1.0.jar pix-1.0.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "pix-1.0.jar"]