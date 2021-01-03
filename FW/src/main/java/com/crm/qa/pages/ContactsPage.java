package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.CRMBase;


public class ContactsPage extends CRMBase {

	@FindBy(xpath = "//i[contains(@class,'edit icon')]//parent::button[contains(@class,'ui linkedin button')]")
	WebElement NewContactBtn;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;

	@FindBy(xpath = "//div[contains(@name,'company')]//input")
	WebElement company;

	@FindBy(xpath = "//i[contains(@class,'save icon')]//parent::button[contains(@class,'ui linkedin button')]")
	WebElement saveBtn;

	@FindBy(xpath = "//i[contains(@class,'large user red icon')]")
	WebElement contactRedIcon;

	// Initialization of page object
	public ContactsPage() {
		PageFactory.initElements(driver, this);

	}

	public void verifyAddContacts(String FirstName, String LastName, String Company) {
		NewContactBtn.click();
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		company.sendKeys(Company);
		company.sendKeys(Keys.TAB);
		saveBtn.click();
	}

	public void verifyContactsRedIcon() {
		explicitWaitElementPresent(contactRedIcon);
		contactRedIcon.isDisplayed();
	}

}
