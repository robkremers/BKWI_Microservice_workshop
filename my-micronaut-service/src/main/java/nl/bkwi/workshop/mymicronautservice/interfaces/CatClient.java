package nl.bkwi.workshop.mymicronautservice.interfaces;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Animal;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Cat;

@Client("http://localhost:6060/animals/animal/cat")
public interface CatClient {

  @Get("/")
  Cat getCat();
}
