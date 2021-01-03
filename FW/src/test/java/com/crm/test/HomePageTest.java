package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;

public class HomePageTest extends CRMBase {

	HomePage homePage;
	CRMLoginPage crmLoginPage;
	ContactsPage contactsPage;
	DealsPage dealsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
		crmLoginPage = new CRMLoginPage();
		String userName = (String) prop.get("userName");
		String password = (String) prop.get("password");
		crmLoginPage.login(userName, password);

	}

	@Test(priority = 1)
	public void validateHomePageTitleTest() {
		String hpt = homePage.validateTitleOfHomePage();
		Assert.assertEquals(hpt, "Cogmento CRM", "Home page title does not matched!");
	}

	@Test(priority = 2)
	public void validateHomePageUserNameTest() {
		Assert.assertTrue(homePage.validateUserNameOnHomePage());
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.ClickContactsLink();
	}

	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		dealsPage = homePage.ClickDealsLink();

	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
