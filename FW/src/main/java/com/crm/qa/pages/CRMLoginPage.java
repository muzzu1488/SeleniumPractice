package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;

public class CRMLoginPage extends CRMBase {

	// PageFactory - OR
	@CacheLookup
	@FindBy(name = "email")
	WebElement userName;
	
	@CacheLookup
	@FindBy(name = "password")
	WebElement password;
	
	@CacheLookup
	@FindBy(xpath = "//div[contains(text(),'Login')]")
	WebElement loginButton;
	
	@CacheLookup
	@FindBy(xpath = "//span[contains(text(),'Log In')]//parent::a")
	WebElement log_in;

	// Initialization of page object
	public CRMLoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		
		log_in.click();
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}

}
