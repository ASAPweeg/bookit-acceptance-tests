package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefinitions {

// OPTION + ENTER       MAC
// ALT + ENTER       WINDOWS

    @When("user logs in as a team lead")
    public void user_logs_in_as_a_team_lead() {
        System.out.println("I am logging in");
        System.out.println("email: " + ConfigurationReader.getProperty("leader_email"));
        System.out.println("password: " + ConfigurationReader.getProperty("leader_password"));
    }

    @Given("user on the login page")
    public void user_on_the_login_page() {
        System.out.println("I am opening the login page");
    }

    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        System.out.println("I can see the home page now!!");
    }

    @Then("the title should be correct")
    public void the_title_should_be_correct() {
        System.out.println("Checking title");
    }

    @When("user logs in as a team member")
    public void user_logs_in_as_a_team_member() {
        System.out.println("I am logging in as member");
    }

    @When("user logs in as a teacher")
    public void user_logs_in_as_a_teacher() {
        System.out.println("I am logging in as teacher");
    }


}

