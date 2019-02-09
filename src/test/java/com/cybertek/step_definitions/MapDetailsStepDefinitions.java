package com.cybertek.step_definitions;

import com.cybertek.pages.MapPage;
import com.cybertek.utilities.BrowserUtils;
import cucumber.api.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class MapDetailsStepDefinitions {


    @Then("I should be able to see {string} room")
    public void i_should_be_able_to_see_room(String roomName) {
        // get list of all the room names and convert into list string
        MapPage mapPage = new MapPage();
        // getting the list of rooms as a webelement from the mappage
        // and returning it as a list of string using the utility method
        List<String> allRooms = BrowserUtils.getElementsText(mapPage.allRooms);
        // verify that list contains the expected room name
        Assert.assertTrue("Room was not found: "+roomName, allRooms.contains(roomName));

    }


    @Then("the user should be able to see following conference rooms:")
    public void the_user_should_be_able_to_see_following_conference_rooms(List<String> rooms) {
        System.out.println(rooms);
        System.out.println(rooms.size());
    }



}
