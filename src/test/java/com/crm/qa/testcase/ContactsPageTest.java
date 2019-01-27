package com.crm.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.crmBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends crmBase {

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	TestUtil tu;
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void openBrowser() {
		initialization();
		lp = new LoginPage();
		hp = new HomePage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp = new ContactsPage();
		tu = new TestUtil();
		tu.switchToFrame();
		hp.clickContacts();
	}

	@Test(priority = 8)
	public void verifyContactPageTest() {
		Assert.assertTrue(cp.verifyContactPage(), "Contact label is missing");
	}
	@DataProvider
	public Object[][] getContactData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority = 9)
	public void selectContactTest() {
		cp.selectContact("JJ JJ");
	}
	@Test(priority = 10, dataProvider = "getContactData")
	public void createContactTest(String titlet, String fnamet, String lnamet, String companyt) {
		hp.clickNewContact();
		cp.createContact(titlet, fnamet, lnamet, companyt);
		cp.verifyContactPage();
	}
	

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
