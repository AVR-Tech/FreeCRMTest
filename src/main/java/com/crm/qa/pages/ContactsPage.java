package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.crmBase;

public class ContactsPage extends crmBase{
	
	@FindBy (xpath = "//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement ContactPage;
	
	@FindBy (name="title")
	@CacheLookup
	WebElement selectTitle;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyLookup;
	
	@FindBy (xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")	
	WebElement submitBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactPage(){
		return ContactPage.isDisplayed();
	}
	
	public void selectContact(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	public void createContact(String title, String fname, String lname, String company){
		Select value = new Select(selectTitle);
		value.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyLookup.sendKeys(company);
		submitBtn.click();	
			}
	
	
}
