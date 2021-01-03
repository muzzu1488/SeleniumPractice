package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;

public class HomePage extends CRMBase {
	
	@FindBy(xpath= "//span[contains(text(),'Mohammed Muzaffar Khan')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Mohammed Muzaffar Khan')]")
	WebElement UserNameLabelOnHomePage;
	
	// Initialization of page object
		public HomePage() {
			PageFactory.initElements(driver, this);

		}
		
		public String validateTitleOfHomePage() {
			return driver.getTitle();
		}
		
		public ContactsPage ClickContactsLink() {
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage ClickDealsLink() {
			DealsLink.click();
			return new DealsPage();
		}
		
		public boolean validateUserNameOnHomePage() {			
			return UserNameLabelOnHomePage.isDisplayed();		
		}

}
