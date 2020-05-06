package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonWeb.BasePage;

public class HomePage extends BasePage{
	
	@FindBy(xpath="//a[text()='Sign Up']") WebElement signUp;
	@FindBy(xpath="//a[text()='About']") WebElement about;
	@FindBy(xpath="//a[text()='CRM']") WebElement crm;
	@FindBy(xpath="//li//a[text()='CRM for Any Business']") WebElement crmForAnyBusiness;
	@FindBy(xpath="//li//a[text()='HIPAA CRM ']") WebElement hippaCrm;
	@FindBy(xpath="//img[@title='free crm app for itunes']") WebElement crmAppForItunes;
	@FindBy(xpath="//img[@title='app for freecrm android']") WebElement crmAppForAndroid;
	@FindBy(xpath="//span[text()='Log In']//parent::a") WebElement logIn;
	@FindBy(xpath="//span[contains(text(),' sign up')]/parent::a") WebElement SignUp;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		waitForElement(60,logIn);
		logIn.click();
	}
	

}
