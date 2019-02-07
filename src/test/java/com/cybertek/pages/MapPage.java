package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MapPage {

    public MapPage() {
        PageFactory.initElements(Driver.getDriver(),
                this);
    }

    @FindBy(tagName = "h1")
    public WebElement header;

    @FindBy(className = "map")
    public WebElement map;

    @FindBy(className = "subtitle")
    public WebElement location;

}
