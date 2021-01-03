package com.crm.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.utils.TestUtils;

public class ContactPageTest extends CRMBase {

	ContactsPage contactsPage;
	CRMLoginPage crmLoginPage;
	HomePage homePage;
	TestUtils testUtils;
	String sheetName = "contacts";

	public ContactPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		contactsPage = new ContactsPage();		
		crmLoginPage = new CRMLoginPage();
		homePage = new HomePage();
		String userName = (String) prop.get("userName");
		String password = (String) prop.get("password");
		crmLoginPage.login(userName, password);
		homePage.ClickContactsLink();
	}

	@DataProvider
	public Object[][] CrmTestData() {
		Object[][] Data = TestUtils.GetTestData(sheetName);
		return Data;
	}

	@Test(priority = 1, dataProvider = "CrmTestData")
	public void verifyAddContacts(String FirstName, String LastName, String Company) {		
		contactsPage.verifyAddContacts(FirstName, LastName, Company);
		contactsPage.verifyContactsRedIcon();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
