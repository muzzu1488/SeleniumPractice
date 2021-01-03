package com.crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.CRMBase;
import com.crm.qa.pages.CRMLoginPage;
import com.crm.qa.pages.HomePage;

public class LoginPageTest extends CRMBase {

	CRMLoginPage LoginPage;
	HomePage homePage;
	String userName;
	String password;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage = new CRMLoginPage();
		homePage = new HomePage();
		userName = (String) prop.get("userName");
		password = (String) prop.get("password");
	}

	@Test(priority = 1)
	public void ValidateLoginPageTest() {

		String PageTitle = LoginPage.validateLoginPageTitle();
		Assert.assertEquals(PageTitle, "Free CRM #1 cloud software for any business large or small");

	}

	@Test(priority = 2)
	public void validateFreeCRMLoginTest() {

		LoginPage.login(userName, password);
		homePage.validateUserNameOnHomePage();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
