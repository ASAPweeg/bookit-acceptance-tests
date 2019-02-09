package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyTeamNavigation extends NavigationMenu {

    public MyTeamNavigation() {
        PageFactory.initElements(Driver.getDriver(),
                this);
    }

    @FindBy(xpath = "//p[.='name']/../p[1]")
	List<WebElement> allNames;

	@FindBy(xpath = "//p[.='role']/../p[1]")
	List<WebElement> allRoles;


}
