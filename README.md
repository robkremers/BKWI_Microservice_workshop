BKWI_Microservice_workshop
Workshop at BKWI for Micronaut and PACT

Short description regarding the different microservices.
Date: 2020-04-17.

In the the commit the following microservices are present:

Start up:
my-micronaut-service
	my-second-micronaut-service
	my-animal-service

After this can be executed:
restassuredworkshop
- MyFirstRestAssuredTestClass

Some calls:
- http://localhost:9090/helloworld
- http://localhost:9090/remote/<name>
- http://localhost:7070/wereldvan/<name>
- http://localhost:6060/dieren/v1/dier/Dog
- http://localhost:9090/remote/getCat
- http://localhost:9090/remote/animalService/cow

Initial: </br>
$ git init</br>
$ git pull https://github.com/robkremers/BKWI_Microservice_workshop.git</br>
$ git status</br>
$ git add .</br>
$ git commit -m "Initial commit."</br>
$ git pull https://github.com/robkremers/BKWI_Microservice_workshop.git</br>
$ git remote add origin https://github.com/robkremers/BKWI_Microservice_workshop.git</br>
$ git push -u origin master</br>
