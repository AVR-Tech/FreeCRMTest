package com.crm.qa.testcase;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.crmBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends crmBase {

	LoginPage lp;
	HomePage hp;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void openBrowser() {
		initialization();
		lp = new LoginPage();
	}

	@Test(priority = 1)
	public void validatePageTitleTest() {
		String title = lp.validatePageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}

	@Test(priority = 2)
	public void validateCRMLogoTest() {
		boolean flag = lp.validateCRMLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterMethod
	public void closeBrowser() {
		// driver.quit();
	}

}
