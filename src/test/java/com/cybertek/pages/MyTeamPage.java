package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyTeamPage extends NavigationMenu {

    @FindBy(xpath = "//p[.='name']/../p[1]")
	public List<WebElement> allNames;

	@FindBy(xpath = "//p[.='role']/../p[1]")
	public List<WebElement> allRoles;


}
