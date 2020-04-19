package nl.bkwi.workshop.mymicronautservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import java.util.List;
import javax.inject.Inject;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Animal;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Cat;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Dog;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Cow;
import nl.bkwi.workshop.mymicronautservice.interfaces.AnimalClient;
import nl.bkwi.workshop.mymicronautservice.interfaces.CatClient;
import nl.bkwi.workshop.mymicronautservice.interfaces.HelloWorldByNameClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller(value = "/")
public class HelloWorldController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldController.class);

  @Inject
  HelloWorldByNameClient externalHelloService;

  @Inject
  AnimalClient animalClient;

  @Inject
  CatClient catClient;

  @Get(value="/helloworld")
  @Produces(MediaType.TEXT_PLAIN)
  public String getHelloWorldResponse() {
    return "Hello World!";
  }

  @Get(value = "/remote/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String getPersonsName(String name) {
    return externalHelloService.getPersonByName(name);
  }

  /**
   * Note that
   *
   * @param animalType
   * @return
   */
  @Get("/remote/animalService/{animalType}")
  public String getAnimal(String animalType) throws JsonProcessingException {
    LOG.info("Animal called: " + animalType);

    ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(animalClient.getAnimal(animalType) );
  }

  /**
   * Result:
   * MutableAnimals.Cat(color=Wit, meowSound=Prr, name=null, favoriteCandy=Katten_snoepjes_en_vis, rasType=Blauwe_Rus, favoriteToy=Nep_muis, note=Blauwe_Rus)
   * @return
   */
  @Get("/remote/getCat")
  @Produces(MediaType.TEXT_PLAIN)
  public String getCat() throws JsonProcessingException {

    Cat cat = catClient.getCat();
    ObjectMapper objectMapper = new ObjectMapper();

    LOG.info("cat: " + cat);
    return objectMapper.writeValueAsString(cat );
  }

}
