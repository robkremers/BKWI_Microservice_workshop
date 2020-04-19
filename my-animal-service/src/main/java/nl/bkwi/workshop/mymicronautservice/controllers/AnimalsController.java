package nl.bkwi.workshop.mymicronautservice.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Animal;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Cat;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Cow;
import nl.bkwi.workshop.mymicronautservice.controllers.MutableAnimals.Dog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller(value = "/")
public class AnimalsController {

  private static final Logger LOG = LoggerFactory.getLogger(AnimalsController.class);

  static Cat cat = new MutableAnimals.CatBuilder()
      .color("Wit")
      .candy("Katten_snoepjes_en_vis")
      .rasSoort("Blauwe_Rus")
      .meowSound("Prr")
      .toy("Nep_muis")
      .build();

  static Dog dog = new MutableAnimals.DogBuilder()
      .candy("Honden snoepjes")
      .color("bruin")
      .ras("herder")
      .barkSound("WHOOF!!!")
      .speeltje("Rubberen eend en touw")
      .build();

  static Cow cow = new MutableAnimals.CowBuilder()
      .race("Lakenvelder")
      .color("White and brown")
      .candy("sugar")
      .booSound("Mooeueuhhh")
      .toy("bell")
      .build();

  @Get("/dieren/v1/dier/{dier}")
  public Animal dier(String dier) {

    LOG.info("Called animal: " + dier);
    dier = dier.toLowerCase();

    if (dier.equals("cat")){
      LOG.info("Cat returned: " + cat.getNote());
      return cat;
    } else if (dier.equals("dog")) {
      LOG.info("Dog returned: " + dog.getNote());
      return dog;
    } else if (dier.equals("cow")) {
      LOG.info("Cow returned: " + cow.getNote());
     return cow;
    } else
      return null;
  }

  @Get("/animals/animal/cat")
  public Cat getCat() {
    LOG.info("Called cat.");
    return cat;
  }



}
