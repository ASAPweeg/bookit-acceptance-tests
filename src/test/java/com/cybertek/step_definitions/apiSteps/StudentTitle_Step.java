package com.cybertek.step_definitions.apiSteps;

import apiModuls.Student;
import com.cybertek.utilities.APIRunner;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StudentTitle_Step {

    @When("user hits all student API {string}")
    public void user_hits_all_student_API(String uri) {
        APIRunner.runGET(uri);
    }

    @Then("user tests the titles")
    public void user_tests_the_titles() {
        int counter = 0;
        for(Student student : APIRunner.getResponse().getStudents()){
          String title =   student.getCompany().getTitle();
            System.out.println(title);
            Assert.assertTrue("Student title is failing at index: " + counter
                    ,title.length() > 1 );

            counter++;
        }
    }



    @Then("user verifies each students email address to be valid")
    public void user_verifies_each_students_email_address_to_be_valid() {
        int counter = 0;
        for(Student student : APIRunner.getResponse().getStudents()){
            String email = student.getContact().getEmailAddress();
            System.out.println(email);
            Assert.assertTrue("Student email is failing at index: " + counter,
                    email.contains("@") && email.contains("."));

            counter++;
        }

    }


}
