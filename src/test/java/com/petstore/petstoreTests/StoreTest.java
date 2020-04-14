package com.petstore.petstoreTests;

import com.petstore.utilities.ConfigurationReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class StoreTest {

    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = ConfigurationReader.get("petstore.uri");
    }


    /*
    Given Accept type and Content type is JSON
    And request json body is:
    {
    "id": 3,
    "petId": 10,
    "quantity": 1,
    "shipDate": "2020-04-14T21:14:14.770Z",
    "status": "placed",
    "complete": true
	}
    When user sends POST request to '/store/order'
    Then status code should be 200
    And Content type should be application/json
    And Verify json response has the same data what is posted
    */


    @Test
    public void PostStoreTest(){

        //I send post request to store
        Response response = given().accept(ContentType.JSON).
                            and().contentType(ContentType.JSON).
                            and().body("{\n" +
                                    "    \"id\": 3,\n" +
                                    "    \"petId\": 10,\n" +
                                    "    \"quantity\": 1,\n" +
                                    "    \"shipDate\": \"2020-04-14T21:14:14.770Z\",\n" +
                                    "    \"status\": \"placed\",\n" +
                                    "    \"complete\": true\n" +
                                    "\t}").when().post("/store/order");

        //I assert the status code and content type
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(), "application/json");

        //I create object from POJO class and store my response body in my object
        Order order = response.body().as(Order.class);

        //I get the id value by the help of my pojo object and assert if it is true
        int idFromPost = order.getId();
        assertEquals(idFromPost,3);

        //I get the petId value by the help of my pojo object and assert if it is true
        int petIdFromPost = order.getPetId();
        assertEquals(petIdFromPost,10);

        //I get the quantity value by the help of my pojo object and assert if it is true
        int quantityFromPost = order.getQuantity();
        assertEquals(quantityFromPost,1);

        //I get the ship date by the help of my pojo object clean from "+000" and assert if it is true
        String shipDateFromPost = order.getShipDate();
        String updatedShipDate = shipDateFromPost.substring(0,23) + "Z";
        assertEquals(updatedShipDate,"2020-04-14T21:14:14.770Z");

        //I get the status by the help of my pojo object and assert if it is true
        String statusFromPost = order.getStatus();
        assertEquals(statusFromPost,"placed");

        //I get the complete value by the help of my pojo object and assert if it is true
        Boolean completeFromPost = order.isComplete();
        assertTrue(completeFromPost);

        //Then I send get request to my created id and assert it with hamcrest matcher to verify order is created
            given().pathParam("orderId", idFromPost).
                    when().get("/store/order/{orderId}").
                    then().assertThat().statusCode(200);

    }

}
