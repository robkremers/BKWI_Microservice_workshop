package nl.bkwi.workshop.mymicronautservice.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller(value = "/wereldvan")
public class HelloWorldByNameController {

  private static final Logger LOG = LoggerFactory.getLogger(HelloWorldByNameController.class);

  @Get(value = "/{name}")
  @Produces(MediaType.TEXT_PLAIN)
  public String getWorldByName(String name) {
    String helloWorldName = "Hoi " + name + "'s wereld";
    LOG.info("Called name: " + name);
    return helloWorldName;
  }

}
