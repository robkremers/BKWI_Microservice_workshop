package nl.bkwi.workshop.mymicronautservice.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MutableAnimals {

  private static final Logger LOG = LoggerFactory.getLogger(MutableAnimals.class);

  @Builder(builderMethodName = "dogBuilder")
  public static MutableAnimals.Dog newDog(String ras, String color, String barkSound, String candy, String speeltje) {
    final MutableAnimals.Dog dog = new MutableAnimals.Dog();
    dog.setSound(barkSound);
    dog.setColor(color);
    dog.setFavoriteCandy(candy);
    dog.setRaceType(ras);
    dog.setFavoriteToy(speeltje);
    dog.setNote(MutableAnimals.PetService.treatService(dog));
    return dog;
  }

  @Builder(builderMethodName = "catBuilder")
  public static MutableAnimals.Cat newCat(String rasSoort, String color, String meowSound, String candy, String toy) {
    final MutableAnimals.Cat cat = new MutableAnimals.Cat();
    cat.setSound(meowSound);
    cat.setColor(color);
    cat.setFavoriteCandy(candy);
    cat.setRaceType(rasSoort);
    cat.setFavoriteToy(toy);
    cat.setNote(MutableAnimals.PetService.treatService(cat));
    return cat;
  }

  @Builder(builderMethodName = "cowBuilder")
  public static MutableAnimals.Cow newCow(String race, String color, String booSound, String candy, String toy ) {
    final MutableAnimals.Cow cow = new MutableAnimals.Cow();
    cow.setRaceType(race);
    cow.setSound(booSound);
    cow.setColor(color);
    cow.setFavoriteCandy(candy);
    cow.setFavoriteToy(toy);
    cow.setNote(MutableAnimals.PetService.treatService(cow));
    return cow;
  }

  @Data
  public static class Cat implements MutableAnimals.Animal {

    private static final long serialVersionUID = -118617321162203433L;
    String color;
    String sound;
    String raceType;
    String favoriteCandy;
    String favoriteToy;
    String note;
  }

  @Data
  public static class Dog implements MutableAnimals.Animal {

    private static final long serialVersionUID = -2337960045638470987L;
    String color;
    String sound;
    String raceType;
    String favoriteCandy;
    String favoriteToy;
    String note;
  }

  @Data
  public static class Cow implements MutableAnimals.Animal {

    private static final long serialVersionUID = 107947266531924813L;
    String color;
    String sound;
    String raceType;
    String favoriteCandy;
    String favoriteToy;
    String note;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
  @JsonSubTypes({
      @JsonSubTypes.Type(value = Dog.class, name = "Dog"),

      @JsonSubTypes.Type(value = Cat.class, name = "Cat"),
      @JsonSubTypes.Type(value = Cow.class, name = "Cow") }
  )
  public interface Animal extends Serializable {
    String getColor();
    String getSound();
    String getRaceType();
    String getFavoriteCandy();
    String getFavoriteToy();
    String getNote();
  }

  @Data
  public static class PetService {

    private PetService() {
    }

    public static String treatService(MutableAnimals.Animal dier) {
      String treatMethod = "Een " + dier.getRaceType() + " Snoept graag " + dier.getFavoriteCandy() + " en speelt graag met een " + dier.getFavoriteToy();
      LOG.info("PetService: " + treatMethod);
      return treatMethod;
    }
  }

}
