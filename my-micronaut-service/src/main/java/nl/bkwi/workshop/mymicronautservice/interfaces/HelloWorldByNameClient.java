package nl.bkwi.workshop.mymicronautservice.interfaces;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;

@Client("http://localhost:7070/wereldvan")
public interface HelloWorldByNameClient {

  @Get("/{name}")
  String getPersonByName(String name);

}
