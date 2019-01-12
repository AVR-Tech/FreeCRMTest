package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.crmBase;

public class HomePage extends crmBase {
	
	@FindBy (xpath = "//td[contains(text(),'User: Vimal raj')]")
	WebElement logUser;
	
	@FindBy (xpath = "//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactLink;	
		
	@FindBy (xpath = "//*[@id='navmenu']/ul/li[5]/a")
	WebElement dealLink;
	
	@FindBy (xpath = "//*[@id='navmenu']/ul/li[6]/a")
	WebElement taskLink;
	
	@FindBy (xpath="//td[contains(text(),'User: Vimal raj']")
	WebElement verifyName;
	
	@FindBy (xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage (){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyPageTitle(){
		String title = driver.getTitle();
		return title;		
	}
	
	public boolean verifyName(){
		return verifyName.isDisplayed();		
	}

	public ContactsPage clickContacts(){
		contactLink.click();
		return new ContactsPage();
	}
	
	/*public TasksPage clickTasks(){
		taskLink.click();
		return new TasksPage();
	}
	
	public DealsPage clickDeals(){
		dealLink.click();
		return new DealsPage();
	}*/
	
	public void clickNewContact(){
		Actions move = new Actions(driver);
		move.moveToElement(contactLink).build().perform();
		newContact.click();		
	}
	
	
	
	
	
	
	
}
