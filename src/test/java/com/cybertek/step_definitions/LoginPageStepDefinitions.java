package com.cybertek.step_definitions;


import cucumber.api.java.en.When;

public class LoginPageStepDefinitions {

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String email, String password) {
        System.out.println("Email: "+ email);
        System.out.println("Password: "+ password);
    }

    @When("title should be {string}")
    public void title_should_be(String title) {
        System.out.println("title: "+title);
    }

    @When("there should be {int} menu options")
    public void there_should_be_menu_options(Integer count) {
        System.out.println("count = " + count);
    }



}
