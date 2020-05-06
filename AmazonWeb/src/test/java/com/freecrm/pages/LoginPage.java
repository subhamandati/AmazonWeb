package com.freecrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonWeb.BasePage;

public class LoginPage extends BasePage{
	
	@FindBy(xpath="//input[@name='email']") WebElement email;
	@FindBy(xpath="//input[@name='password']") WebElement password;
	@FindBy(xpath="//div[text()='Login']") WebElement logIn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		waitForElement(60, email);
		email.sendKeys("subhashini.reddy2@gmail.com");
		password.sendKeys("Mandati@89");
		logIn.click();	
	}

}
