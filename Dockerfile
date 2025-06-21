# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-alpine
# Metadata as a label 
LABEL version="1.0.0" description="Random quotes Spring Microservice, built with Spring Boot and Gradle, uses data from Quotes Hub API" 
# Copy the JAR file to the container 
ADD target/randomquotes-hxsc-1.0.0.jar randomquotes-hxsc-1.0.0.jar 
# Run the application 
ENTRYPOINT [ "java","-jar","randomquotes-hxsc-1.0.0.jar" ]
