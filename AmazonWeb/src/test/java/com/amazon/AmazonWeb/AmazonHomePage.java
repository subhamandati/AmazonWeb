package com.amazon.AmazonWeb;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class AmazonHomePage extends BasePage {
  @Test(enabled = false)
  
  public void f() throws Exception {
		LoginPage lp = new LoginPage(driver);
		Thread.sleep(1000);
		lp.login();
		Assert.assertEquals(lp.error_message(), "Authentication failed.");

  }
  
  @Test
  public void registerCustomer()
  {
	  CustomerRegistrationPage crp = new CustomerRegistrationPage(driver);
	  crp.fb_checkbox();
  }
  
  @BeforeMethod
  @Parameters({"browser"})
  public void beforeMethod() throws Exception {
	  init();
	  launch("chrome");
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize(); 
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }
  

}
