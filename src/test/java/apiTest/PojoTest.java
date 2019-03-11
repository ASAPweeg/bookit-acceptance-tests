package apiTest;

import apiModuls.Instructor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

public class PojoTest {


    @Test
    public void testPojo() throws Exception {
        Instructor in = new Instructor();
        in.setBatch(10);
        in.setFirstName("Feruk");
        in.setLastName("Coskun");
        in.setSubject("SDET");
        in.setId(363);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(in);

        System.out.println(json);


        Instructor in2 = mapper.readValue(json, Instructor.class);

        System.out.println("Batch: " + in2.getBatch() + "\n" +
                "First Name: " + in2.getFirstName() + "\n" +
                "Last Name: " + in2.getLastName() + "\n" +
                "Subject: " + in2.getBatch() + "\n" +
                "ID: " + in2.getId());



    }
}


























