package com.spicejet;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

public class LoginPage extends BasePage {
 
 @BeforeMethod
 @Parameters("browser")
 public void setup(String browser, String url) throws Exception 
 {
	  init();
	  launch(browser,url);
 }
 @Test(enabled=false)
  public void hotels(String url ) {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='myspice_trip']")));
	  driver.findElement(By.xpath("//li[@class='myspice_trip']")).click();
	
  }
  
  @Test
  public void holidays() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='holiday-packages']")));
	driver.findElement(By.xpath("//li[@class='holiday-packages']")).click();
  }
  
  @Test
  public void flight_status() {
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='flight_status']")));
	  driver.findElement(By.xpath("//li[@class='flight_status']")).click();
  }
  
  @AfterMethod
  public void tearDown() 
  {
	  driver.quit();
  }
}
