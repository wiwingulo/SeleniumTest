package com.nexsoft.testNG;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegisterTest {

	protected WebDriver driver;
	private JavascriptExecutor jsExe;
	
	public void delayMS(int inInt) {
		try {
			Thread.sleep(inInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String screenShot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String fileName = "D:\\TestScreenshoot\\" + waktu + ".png";
		File screenshot = new File(fileName);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}



	@BeforeTest
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		jsExe = (JavascriptExecutor) driver;
	}
	
	
	
	@Test(priority = 0)
	public void testRegister() {
		
		WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickHomePage();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("wiwingulshu", "wiwin123", "wiwin123", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);

	}
	@Test(priority = 1)
	public void testRegisterUserIdNull() {
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("", "wiwin123", "wiwin123", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");

		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);

	}
	@Test(priority = 2)
	public void testRegisterUserIdDuplicat() {
		
		WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickHomePage();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("wiwingulo", "wiwin123", "wiwin123", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		

	}
	@Test(priority = 3)
	public void testRegisterNullNewPassword() {
		
		WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickHomePage();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("wiwingulo", "", "wiwin123", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		

	}
	@Test(priority = 4)
	public void testRegisterNullRepeatPassword() {
		
		WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickHomePage();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("wiwingulo", "wiwin123", "", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);

	}
	@Test(priority = 5)
	public void testRegisterNewAndRepeatPasswordNotSame() {
		
		WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
		welcomePage.clickHomePage();
		
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.clickLoginPage();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickSignInPage().loginValidUser("wiwingulo", "wiwin123", "wiwin123dsa", "Wiwin","Gulo" , "wiwingulo@gmail.com", 
												   "0128312", "Medan", "Cirebon", "Medan","Indo" , "321823", "Indo", 
												   "japanese", "FISH");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
		

	}
	
	
	
	
	
	
	
	
	
}
