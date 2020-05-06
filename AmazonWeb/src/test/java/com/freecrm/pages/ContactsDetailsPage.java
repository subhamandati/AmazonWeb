package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsDetailsPage {
	
	@FindBy(xpath="//div[text()='Category']/parent::div/div[2]") WebElement category;
	@FindBy(xpath="//div[text()='Status']/parent::div/div[2]/div") WebElement status;
	@FindBy(xpath="//div[text()='Company']/parent::div/div[2]") WebElement company;
	@FindBy(xpath="//div[text()='Email']/parent::div/div[2]") WebElement email;
	
	public ContactsDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void getCategory()
	{
		 String categorytext = category.getText();
		 System.out.println("categorytext is" + categorytext);
		 
	}
	
	public void getStatus()
	{
		 String statustext = status.getText();
		 System.out.println("statustext is" + statustext);
		 
	}
	
	

	

	

}
