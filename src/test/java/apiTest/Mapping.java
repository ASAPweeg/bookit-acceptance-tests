package apiTest;


import apiModuls.Instructor;
import apiModuls.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import groovy.json.internal.IO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;


public class Mapping {


    @Test
    public void pojoMapping() throws IOException {

        String json = "{\"id\":3,\"firstName\":\"Wooden\",\"lastName\":\"Spoon\",\"batch\":10,\"subject\":\"Corporate World\"}";
        ObjectMapper mapper = new ObjectMapper();
        Instructor instructor = mapper.readValue(json, Instructor.class);
        System.out.println(instructor.getFirstName());


    }

    @Test
    public void objectToJson() throws IOException {
        Instructor instructor = new Instructor();
        instructor.setSubject("Intro to CS123");
        instructor.setId(34);
        instructor.setFirstName("Howward1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(instructor); //Object to JSON
        System.out.println(json);


    }

    @Test
    public void singleStudent() throws IOException {
        Response response = RestAssured.get("http://cybertekchicago.com/student/87");
        System.out.println(response.asString());
        System.out.println(response.getStatusCode());
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(response.asString(), Student.class);
        System.out.println(student.getFirstName());
        System.out.println(student.getContact().getEmailAddress());

    }
}
