package com.shopperStackGenericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
	Java_Utility javautility=new Java_Utility();

public void takeWebPageScreenshot() throws IOException {
	TakesScreenshot ts=(TakesScreenshot) Base_Test.sDriver;
	File temp = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(FrameWorkContants.screenshotPath+javautility.localDateTime()+".png");
	FileHandler.copy(temp, dest);
	
	
}

public void takeWebElementScreenshot(WebElement element) throws IOException {
	File temp=element.getScreenshotAs(OutputType.FILE);
	File dest=new File(FrameWorkContants.screenshotPath+javautility.localDateTime()+".png");
	FileHandler.copy(temp, dest);
	
	
}
public void selectbyvalue(WebElement element,String value) {
	Select select=new Select(element);
	select.selectByValue(value);
	
}
}
