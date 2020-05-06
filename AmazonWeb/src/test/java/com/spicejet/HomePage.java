package com.spicejet;

import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
public class HomePage extends BasePage{
	

  @BeforeMethod
  @Parameters("browser")
  
  public void browser(String browser) throws Exception 
  {
	  init();
	  launch(browser);
  }

  @Test
  public void get_url() 
  {
	System.out.println(driver.getCurrentUrl()); 
  }
  
  @Test
  public void verify_login_link() 
  {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='Login']")));
	  driver.findElement(By.xpath("//a[@id='Login']")).click();
  }
  
  @Test
  public void get_headers()
  {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='book_flight']")));
	  driver.findElement(By.xpath("//li[@class='book_flight']")).isDisplayed();
	  
  }
  

  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }

}
