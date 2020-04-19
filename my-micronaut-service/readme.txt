Execute in the root directory of the project:

# Building the container
$ docker build -t my-micronaut-service .

# Running the container
$ docker container run --name my-micronaut-service --network=host
# Result:


$ docker container run --name my-micronaut-service --net workshop -p 8080:9090 my-micronaut-service

$ docker container run \
--name my-micronaut-service \
--net workshop \
--env application=my-second-micronaut-service my-micronaut-service

Fixing the problems in class MutableAnimals:
https://stackoverflow.com/questions/30362446/deserialize-json-with-jackson-into-polymorphic-types-a-complete-example-is-giv/30386694#30386694
