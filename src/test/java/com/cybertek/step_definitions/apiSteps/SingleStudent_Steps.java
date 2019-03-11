package com.cybertek.step_definitions.apiSteps;

import com.cybertek.utilities.APIRunner;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SingleStudent_Steps {

    @When("user hits single student API with {string}")
    public void user_hits_single_student_API_with(String uri) {

        APIRunner.runGET(uri);

    }

    @Then("user tests for required attributes")
    public void user_tests_for_required_attributes() {

        System.out.println("First name: " +  APIRunner.getResponse().getFirstName());
        System.out.println("Last name: " +  APIRunner.getResponse().getLastName());

        Assert.assertTrue("Student First name is missing",APIRunner.getResponse().getFirstName() != null);
        Assert.assertTrue("Student Last name is missing",APIRunner.getResponse().getLastName() != null);
        Assert.assertTrue("Student Email address is missing",APIRunner.getResponse().getContact().getEmailAddress() == null);
        Assert.assertTrue("Student City is missing",APIRunner.getResponse().getCompany().getAddress().getCity() != null);


    }

}
