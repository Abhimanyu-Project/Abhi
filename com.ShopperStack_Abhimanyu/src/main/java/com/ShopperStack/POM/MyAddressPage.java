package com.ShopperStack.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAddressPage {
	public MyAddressPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAddressButton;
	
	@FindBy(xpath="(//span[contains(@class,'MuiButton-startIcon')])[2]")
	private WebElement deleteButton;
	
	@FindBy(xpath="(//button[text()='Yes'])[1]")
	private WebElement yesButton;

	public WebElement getAddAddressButton() {
		return addAddressButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public WebElement getYesButton() {
		return yesButton;
	}

}
