package com.nexsoft.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

	protected WebDriver driver;
	
	@FindBy(css="a[href='actions/Catalog.action']")
	private WebElement textHomePage;
	
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage clickHomePage() {
		textHomePage.click();
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		return homePage;
	}
}
