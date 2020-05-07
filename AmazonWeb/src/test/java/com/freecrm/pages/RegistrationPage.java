package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonWeb.BasePage;

public class RegistrationPage extends BasePage{
	
	@FindBy(xpath="//input[@name='email']") WebElement email;
	@FindBy(xpath="//input[@name='phone']") WebElement phone;
	@FindBy(xpath="//input[@name='terms']") WebElement terms;
	@FindBy(xpath="//button[contains(text(),'Sign Up')]") WebElement signUp;
	
	
	public RegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void register()
	{
		waitForElement(60,email);
		email.sendKeys("testuser21@gmail.com");
		waitForElement(60,phone);
		phone.sendKeys("sdgssf");
		terms.click();
		waitForElement(60,signUp);
		signUp.click();
		
		
		
	}
	
	

}
