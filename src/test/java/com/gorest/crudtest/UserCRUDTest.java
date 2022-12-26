package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
//776f75c7b8747aa50f4c8f23f1cedc266fdb3940865f1a5821385297ddf55956
    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Manan Shah");
        userPojo.setEmail("123test@gmail.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given()
                        .header("Content-Type","application/json")
                        .header("Authorization", "776f75c7b8747aa50f4c8f23f1cedc266fdb3940865f1a5821385297ddf55956")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();


    }
    @Test
    public void getAllCustomersInfo() {
        Response response = given()
                .when()
                .get("/users");
        response.then().statusCode(200);
        response.prettyPrint();

    }
    @Test
    public void deleteUser() {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 5a08acd60a4f9f76dd28e583fa505a76eeaa98e3da1658ee53c924cac7b1d8d1")

                .when()
                .delete("/users/3828");
        response.then().statusCode(204);
        response.prettyPrint();
    }


}
