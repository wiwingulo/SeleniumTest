package com.nexsoft.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
	@FindBy(xpath="//a[normalize-space()='Sign In']")
	private WebElement textLoginPage;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage clickLoginPage() {
		textLoginPage.click();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		return loginPage;
	}
}
