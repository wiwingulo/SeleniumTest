package com.nexsoft.testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage {
	
	protected WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userId;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement newPassword;
	
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	private WebElement repeatPassword;
	
	@FindBy(xpath = "//input[@name='account.firstName']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@name='account.lastName']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='account.email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@name='account.phone']")
	private WebElement phone;
	
	@FindBy(xpath = "//input[@name='account.address1']")
	private WebElement address1;
	
	@FindBy(xpath = "//input[@name='account.address2']")
	private WebElement address2;
	
	@FindBy(xpath = "//input[@name='account.city']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@name='account.state']")
	private WebElement state;
	
	@FindBy(xpath = "//input[@name='account.zip']")
	private WebElement zip;
	
	@FindBy(xpath = "//input[@name='account.country']")
	private WebElement country;
	
	@FindBy(xpath = "//select[@name='account.languagePreference']")
	private WebElement selectorLanguage;
	
	@FindBy(xpath = "//select[@name='account.favouriteCategoryId']")
	private WebElement selectorFavourite;
	
	@FindBy(xpath = "//input[@name='account.listOption']")
	private WebElement listoptMyList;
	
	@FindBy(xpath = "//input[@name='account.listOption']")
	private WebElement listoptMyBanner;
	
	@FindBy (xpath = "//input[@name='newAccount']")
	private WebElement save;
	

	
	public SignInPage (WebDriver driver) {
		this.driver=driver;
	}
	
	public HomePage loginValidUser(String user_Id, String new_password, String repeat_password, String first_name, String 
			last_name, String email_user, String phone_user, String address1_user, String address2_user, 
			String city_user, String state_user, String zip_user, String country_user,String selector_language, String selector_favourite
			) {
			userId.clear();
			userId.sendKeys(user_Id);
			newPassword.clear();
			newPassword.sendKeys(new_password);
			repeatPassword.clear();
			repeatPassword.sendKeys(repeat_password);
			firstName.clear();
			firstName.sendKeys(first_name);
			lastName.clear();
			lastName.sendKeys(last_name);
			email.clear();
			email.sendKeys(email_user);
			phone.clear();
			phone.sendKeys(phone_user);
			address1.clear();
			address1.sendKeys(address1_user);
			address2.clear();
			address2.sendKeys(address2_user);
			city.clear();
			city.sendKeys(city_user);
			state.clear();
			state.sendKeys(state_user);
			zip.clear();
			zip.sendKeys(zip_user);
			country.clear();
			country.sendKeys(country_user);
			selectorLanguage.clear();
			Select select = new Select(selectorLanguage);
			select.selectByValue(selector_language);
			selectorFavourite.clear();
			Select select2 = new Select(selectorFavourite);
			select2.selectByValue(selector_favourite);
			 
			save.click();
			return PageFactory.initElements(driver, HomePage.class);
	}
	

	
}
