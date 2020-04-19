package nl.bkwi.workshop.mymicronautservice.interfaces;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import java.util.List;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Animal;

@Client("http://localhost:6060/dieren/v1/dier")
public interface AnimalClient {

  /**
   * Options: cat, dog, cow. Otherwise null will be returned, which will result in an error message.
   * @param animalType
   * @return
   */
  @Get("/{animalType}")
  Animal getAnimal(String animalType);
}
