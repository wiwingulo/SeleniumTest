package com.nexsoft.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement textSignInPage;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@name='signon']")
	private WebElement login;
	
	@FindBy(xpath = "//li[contains(text(),'Invalid username or password.')]")
	private WebElement errorPassword;
		
	
	public LoginPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public Dashboard clickLogin(String username_user, String password_user) {
		username.clear();
		username.sendKeys(username_user);
		password.clear();
		password.sendKeys(password_user);

		login.click();
		return PageFactory.initElements(driver, Dashboard.class);
	}
	

	
	public SignInPage clickSignInPage() {
		textSignInPage.click();
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}
	

	public String getErrorPassword() {
		return errorPassword.getText();
	}


}
