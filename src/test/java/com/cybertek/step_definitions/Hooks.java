package com.cybertek.step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("I am setting up the test from the Hooks class!!!");
    }

    @After
    public void tearDown(){
        System.out.println("I am reporting the results");
    }
}
