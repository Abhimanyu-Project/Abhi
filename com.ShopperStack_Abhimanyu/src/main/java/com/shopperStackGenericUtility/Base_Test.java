package com.shopperStackGenericUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.ShopperStack.POM.HomePage;
import com.ShopperStack.POM.LoginPage;
import com.ShopperStack.POM.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base_Test {

	public static WebDriver sDriver;
	public File_Utility file = new File_Utility();
	public WebDriver driver;
	public WelcomePage welcome;
	public LoginPage loginpage;
	public HomePage homepage;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public Java_Utility javautility = new Java_Utility();
	public WebDriverWait wait;
	public Webdriver_Utility webdriverUtility = new Webdriver_Utility();

	@BeforeSuite
	public void beforesuite() {
		System.out.println("before suite");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before Test");
		spark = new ExtentSparkReporter(FrameWorkContants.extentReportsPath + javautility.localDateTime() + ".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("before class");

		// Scanner sc=new Scanner (System.in);
		// System.out.println("Enter Browser name");
		// String browser=sc.next();
		// System.out.println("Numbers of Browser");

		String browserName = file.readPropertyData("browserName");
		String url = file.readPropertyData("url");

		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.contains("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();

		} else {
			System.out.println("Invalid browser name");
		}
		sDriver = driver;
		homepage = new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod() throws IOException, InterruptedException {
		System.out.println("before method");

		welcome= new WelcomePage(driver);

		wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		// wait.until(ExpectedConditions.elementToBeClickable(WelcomePage.getLoginButton()));
		wait.until(ExpectedConditions.elementToBeClickable(welcome.getLoginButton()));
		Thread.sleep(4000);

		welcome.getLoginButton().click();

		loginpage = new LoginPage(driver);
		loginpage.getEmailTextField().sendKeys(file.readPropertyData("email"));
		loginpage.getPasswordTextField().sendKeys(file.readPropertyData("password"));
		loginpage.getLoginButton().click();

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {
		System.out.println("AfterMethod");

		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(homepage.getAccountPage()));

		homepage.getAccountPage().click();
		homepage.getLogoutButton().click();

	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("AfterClass");
		Thread.sleep(3000);
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after Test");

		reports.flush();
	}

	public void afterSuite() {
		System.out.println("After suite");
	}

}