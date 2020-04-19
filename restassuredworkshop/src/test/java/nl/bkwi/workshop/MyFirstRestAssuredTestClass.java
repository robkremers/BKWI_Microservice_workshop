package nl.bkwi.workshop;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;
import org.junit.Test;

import static org.hamcrest.Matchers.*;

public class MyFirstRestAssuredTestClass {

  @Test
  public void endpointHelloWorldRespondsWithStatuscode(){
    given()
        .baseUri("http://localhost:9090")
        .when()
        .get("/helloworld")
        .then().statusCode(200);
  }

  @Test
  public void endpointHelloWorldRespondsWithCorrectString(){
    Response response = given()
        .baseUri("http://localhost:9090")
        .when()
        .get("/helloworld");

    System.out.println("Response = " + response.getBody().asString());
    assertEquals("Hello World!", response.getBody().asString());
  }

  @Test
  public void endpointHelloWorldRespondsWithCorrectStringWithThen(){
    given()
        .baseUri("http://localhost:9090")
        .when()
        .get("/helloworld")
        .then().body(equalTo("Hello World!"));
  }


}
