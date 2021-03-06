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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTest {

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
		System.setProperty("url", "https://petstore.octoperf.com/actions/Catalog.action");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(System.getProperty("url"));
		driver.manage().window().maximize();
		jsExe = (JavascriptExecutor) driver;
	}
	
	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));

		// cek session user sudah login atau belum

		LoginPage home = PageFactory.initElements(driver, LoginPage.class);

	}
	

	@Test(priority = 1)
	public void testLogin() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("wiwingulo", "wiwin123");
		dash.logout();
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
		
	
	}
	@Test(priority = 2)
	public void testLoginWithValidUsernameAndWrongPassword() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("wiwingulo", "wiw3");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	
			
	}
	@Test(priority = 3)
	public void testLoginWithWrongUsernameAndValidPassword() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("wiwingsao", "wiwin123");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	
			
	}
	
	@Test(priority = 4)
	public void testLoginWithNullUsernameAndValidPassword() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("", "wiwin123");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	
			
	}
	@Test(priority = 5)
	public void testLoginWithValidUsernameAndNullPassword() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("wiwingulo", "");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	
			
	}
	
	@Test(priority = 5)
	public void testLoginWithNullUsernameAndNullPassword() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		Dashboard dash = homePage.clickLoginPage().clickLogin("", "");
		
		delayMS(500);
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		
		String file = "<img src='file://" + screenShot() + "'height=\"500\" width=\"1100\"/>";
		Reporter.log(file);
	
			
	}
		
	
}
