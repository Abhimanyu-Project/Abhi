package com.ShopperStack_testScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.ShopperStack.POM.AddressFormPage;
import com.ShopperStack.POM.HomePage;
import com.ShopperStack.POM.MyAddressPage;
import com.ShopperStack.POM.MyProfilePage;
import com.aventstack.extentreports.Status;
import com.shopperStackGenericUtility.Base_Test;
import com.shopperStackGenericUtility.Webdriver_Utility;

public class TC_01_Verify_user_is_able_to_add_Address_Test extends Base_Test{
	@Test
	public void addAdress() throws EncryptedDocumentException, IOException, InterruptedException {
		
		test=reports.createTest("AddAdress");
		test.log(Status.PASS,"Login done Successfully");
		
		homepage.getAccountPage().click();
		homepage.getMyprofile().click();
		
		test.log(Status.INFO, "navigated to my profile page");
		
		MyProfilePage myprofilepage=new MyProfilePage(driver);
		myprofilepage.getMyadress().click();
		
		test.log(Status.INFO, "navigated to my addressform  page");
		
		MyAddressPage myAddressPage=new MyAddressPage(driver);
		myAddressPage.getAddAddressButton().click();
		
		AddressFormPage adressformpage=new AddressFormPage(driver);
		adressformpage.getOfficeButton().click();
		
		adressformpage.getNameTextField().sendKeys(file.readExcelData("sheet1", 1, 0));
		adressformpage.getHouseTextField().sendKeys(file.readExcelData("sheet1", 1, 1));
		adressformpage.getStreetTextField().sendKeys(file.readExcelData("sheet1", 1, 2));
		adressformpage.getLandmarkTextField().sendKeys(file.readExcelData("sheet1", 1, 3));
		
		
		webdriverUtility.selectbyvalue(adressformpage.getCountryDropdown(),file.readExcelData("sheet1", 1, 4));
		webdriverUtility.selectbyvalue(adressformpage.getStateDropdown(),file.readExcelData("sheet1", 1, 5));
		webdriverUtility.selectbyvalue(adressformpage.getCityDropdown(), file.readExcelData("sheet1", 1, 6));
		
		adressformpage.getPincodeTextField().sendKeys(file.readExcelData("Sheet1", 1, 7));
		adressformpage.getPhoneNumberTextField().sendKeys(file.readExcelData("Sheet1", 1, 8));
		adressformpage.getAddAdressBtn().click();
		
		Thread.sleep(3000);
		
		webdriverUtility.takeWebPageScreenshot();
	}

}
