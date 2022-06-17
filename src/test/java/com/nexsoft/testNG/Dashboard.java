package com.nexsoft.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard {
	
	protected WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement btnLogout;
	
	@FindBy(xpath = "//div[@id='WelcomeContent']")
	private WebElement username;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getUsername() {

		return username.getText();
	}
	
	public void logout() {

		btnLogout.click();

	}
}
