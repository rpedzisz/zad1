FROM java:8
COPY . /
WORKDIR /
RUN javac DockerConnect.java
CMD ["java", "-classpath", "mysql-connector-java-8.0.13.jar", "DockerConnect"]
