Execute in the root directory of the project:

# Building the container
$ docker build -t my-second-micronaut-service .

# Running the container
$ docker container run -p 8080:7070 my-second-micronaut-service
# Result:
url: http://localhost:8080/wereldvan/rob
--> Hoi rob's wereld
--> So while in application.yml the port 7070 has been specified this is now running container-internal.
For docker the external port is 8080 (specified above).

# Now with a network:

$ docker network create workshop
Result:
d5a906249808025a813f5a3a0ed1673ed19d9af4a1099c71a993e6444018bb76
--> !
$ docker network ls
..
d5a906249808        workshop            bridge              local

$ docker container run --name my-second-micronaut-service --net workshop -p 8080:7070 my-second-micronaut-service
-->
Running:
01:37:00.584 [main] INFO  io.micronaut.runtime.Micronaut - Startup completed in 1370ms. Server Running: http://4265dc646e78:7070
url: http://localhost:8080/wereldvan/rob
--> Hoi rob's wereld
