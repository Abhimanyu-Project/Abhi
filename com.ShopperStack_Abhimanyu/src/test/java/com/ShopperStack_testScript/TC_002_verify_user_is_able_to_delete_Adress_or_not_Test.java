package com.ShopperStack_testScript;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ShopperStack.POM.MyAddressPage;
import com.ShopperStack.POM.MyProfilePage;
import com.shopperStackGenericUtility.Base_Test;

public class TC_002_verify_user_is_able_to_delete_Adress_or_not_Test extends Base_Test {
	@Test
	public void deleteAddress() throws InterruptedException, IOException {
		homepage.getAccountPage().click();
		homepage.getMyprofile().click();
		
		MyProfilePage myprofilePage=new MyProfilePage(driver);
		myprofilePage.getMyadress().click();
		
		
		Thread.sleep(3000);
		MyAddressPage myadressPage=new MyAddressPage(driver);
		myadressPage.getDeleteButton().click();
		Thread.sleep(3000);
		myadressPage.getYesButton().click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		webdriverUtility.takeWebPageScreenshot();
	}

}
