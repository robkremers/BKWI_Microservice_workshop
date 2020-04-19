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

  /**
   * The result of the following is that a serialized object will be sent that has the following
   * format:
   * {
   *     "@type": "Cat",
   *     "color": "Wit",
   *     "favoriteCandy": "Katten_snoepjes_en_vis",
   *     "favoriteToy": "Nep_muis",
   *     "note": "Een Blauwe_Rus Snoept graag Katten_snoepjes_en_vis en speelt graag met een Nep_muis",
   *     "raceType": "Blauwe_Rus",
   *     "sound": "Prr"
   * }
   *
   * As is visible the annotations below will add a meta-propertie "@type".
   * This will enable the corresponding functionality in the consumer to know that it concerns
   * an instance of type cat.
   *
   * See:
   * - https://www.baeldung.com/jackson-exception
   * - https://stackoverflow.com/questions/30362446/deserialize-json-with-jackson-into-polymorphic-types-a-complete-example-is-giv/30386694#30386694
   */
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
      String treatMethod = dier.getNote();
      LOG.info(treatMethod);
      return treatMethod;
    }
  }

}
