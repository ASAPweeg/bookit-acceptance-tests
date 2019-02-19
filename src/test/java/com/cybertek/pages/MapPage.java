package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MapPage extends NavigationMenu {

    @FindBy(linkText = "map")
    public WebElement map;

    @FindBy(css = "a>span.room-name")
    public List<WebElement> allRooms;

    public WebElement room(String roomName) {
        return Driver.getDriver().findElement(By.linkText(roomName));
    }
}
