package apiTest;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class CMstudent {


    @Test
    public void studentList() {

        Response response = RestAssured.get("http://cybertekchicago.com/instructor/alllll");

        // Return Status Code 202 / 404 / 500
        System.out.println(response.statusCode());
//        // Verify the server is up and connected
//        Assert.assertEquals(response.statusCode(),200);


        // 2nd way to Assert ( PURE API Assertion )
        //  RestAssured.given().get("http://cybertekchicago.com/instructor/al").then().statusCode(200);
        /*-------------------------------------------------------------------------------------------------------------*/

        // it will return JSON format
        System.out.println(response.asString());


    }


    /*
    Task :

    Create a test
    Hit API that gets only one student
    print out status and response in string
     */
    @Test
    public void singleStudent() {
        Response response = RestAssured.get("http://cybertekchicago.com/student/70"); //--> Checking the ID: 130 Student
        System.out.println(response.asString());


        // TODO
        //  JSONPATH !!! ~ FINDING THE OBJECT ~
        JsonPath jp = response.jsonPath();

        int batch = jp.get("batch");
        System.out.println(batch);

        String fN = jp.get("firstName");
        System.out.println(fN);


        String email = jp.get("contact.emailAddress");
        System.out.println(email);

        String st = jp.get("company.address.street");
        System.out.println(st);

    }

    @Test
    public void instructorAll() {
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");

        System.out.println(response.getStatusCode());

        System.out.println(response.asString());
        JsonPath jp = response.jsonPath();

        List<String> subjects = jp.get("instructors.subject");

        System.out.println(subjects.size());

        for (String subject : subjects) {
            System.out.println(subject == null); // to validate the data use isEmpty method

        }

    }



}






















