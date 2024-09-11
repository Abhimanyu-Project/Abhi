package com.ShopperStack.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressFormPage {
public AddressFormPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}

@FindBy(id="Office")
private WebElement OfficeButton;

@FindBy(id="Name")
private WebElement nameTextField;

@FindBy(xpath="//input[contains(@id,'House')]")
private WebElement houseTextField;

@FindBy(xpath="//input[contains(@id,'Street')]")
private WebElement StreetTextField;

@FindBy(xpath="//input[@id='Landmark']")
private WebElement landmarkTextField;

@FindBy(id="Country")
private WebElement countryDropdown;

@FindBy(id="State")
private WebElement stateDropdown;


@FindBy(id="City")
private WebElement cityDropdown;


@FindBy(id="Pincode")
private WebElement pincodeTextField;

@FindBy(id="Phone Number")
private WebElement phoneNumberTextField;

@FindBy(id="btnDisabled")
private WebElement disableAddressBtn;


@FindBy(id="addAddress")
private WebElement addAdressBtn;


public WebElement getOfficeButton() {
	return OfficeButton;
}


public WebElement getNameTextField() {
	return nameTextField;
}


public WebElement getHouseTextField() {
	return houseTextField;
}


public WebElement getStreetTextField() {
	return StreetTextField;
}


public WebElement getLandmarkTextField() {
	return landmarkTextField;
}


public WebElement getCountryDropdown() {
	return countryDropdown;
}


public WebElement getStateDropdown() {
	return stateDropdown;
}


public WebElement getCityDropdown() {
	return cityDropdown;
}


public WebElement getPincodeTextField() {
	return pincodeTextField;
}


public WebElement getPhoneNumberTextField() {
	return phoneNumberTextField;
}


public WebElement getDisableAddressBtn() {
	return disableAddressBtn;
}


public WebElement getAddAdressBtn() {
	return addAdressBtn;
}

}
