package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.crmBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends crmBase {

	LoginPage lp;
	HomePage hp;
	TestUtil tu;
	ContactsPage cp;

	public HomePageTest(){
		super();
	}

	@BeforeMethod
	public void openBrowser() {
		initialization();
		lp = new LoginPage();
		tu = new TestUtil();
		cp = new ContactsPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 4)
	public void verifyTitleTest() {
		String title = hp.verifyPageTitle();
		Assert.assertEquals(title, "CRMPRO", "Home Page Title Not Matched");
	}

	@Test(priority = 5)
	public void verifyNameTest() {
		tu.switchToFrame();
		Assert.assertTrue(hp.verifyName());
		/*
		 * boolean nameVeriy = hp.verifyName(); Assert.assertTrue(nameVeriy);
		 */
	}

	@Test(priority = 6)
	public void clickContactsTest() {
		tu.switchToFrame();
		cp = hp.clickContacts();

	}

	@Test(priority = 7)
	public void clickDealsTest() {
		tu.switchToFrame();
		//hp.clickDeals();
	}

}
