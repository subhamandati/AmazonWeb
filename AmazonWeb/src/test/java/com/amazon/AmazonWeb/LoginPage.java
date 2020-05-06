package com.amazon.AmazonWeb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath = "//a[@class='login']") WebElement login;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	@FindBy(xpath = "//p[@class='submit']//span[1]") WebElement submit;
	@FindBy(xpath = "//li[contains(text(),'Authentication failed.')]") WebElement act_mesg;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public void login()
	
	{
		login.click();
		email.sendKeys("subhashini.reddy2@gmail.com");
		password.sendKeys("pass87");
		submit.click();
	}
	
	public String error_message()
	{
		return act_mesg.getText();
	}
	
	

}
