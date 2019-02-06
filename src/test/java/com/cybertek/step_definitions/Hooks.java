package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order = 2)
    public void setUp(){
        System.out.println("I am setting up the test from the Hooks class!!!");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // you can also add maximize screen here
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("I am reporting the results");

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("Closing driver");
        Driver.closeDriver();
    }

    @Before(value = "@teacher", order = 11)
    public void setUpTeacher(){
        System.out.println("Set up teacher test");
    }
}
