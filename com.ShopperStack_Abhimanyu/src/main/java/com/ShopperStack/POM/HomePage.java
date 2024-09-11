package com.ShopperStack.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
public HomePage(WebDriver driver) {
	PageFactory.initElements( driver,this);
	
}

@FindBy(xpath = "//span[contains(@class,'BaseBadge-badge')]")
private WebElement accountPage;


@FindBy(xpath = "//li[text()='My Profile']")
private WebElement myprofile;


@FindBy(xpath = "//li[text()='Logout']")
private WebElement logoutButton;


public WebElement getAccountPage() {
	return accountPage;
}


public WebElement getMyprofile() {
	return myprofile;
}


public WebElement getLogoutButton() {
	return logoutButton;
}
}
