FROM adoptopenjdk/openjdk13-openj9:jdk-13.0.2_8_openj9-0.18.0-alpine-slim
COPY target/my-second-micronaut-service-*.jar my-second-micronaut-service.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-XX:+IdleTuningGcOnIdle", "-Xtune:virtualized", "-jar", "my-second-micronaut-service.jar"]
