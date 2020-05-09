package com.alertshandlig;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

import junit.framework.Assert;

public class Alerts extends BasePage {
	
	@BeforeMethod
	public void setup() throws Exception {
		init();
		launch("chrome", dp.getProperty("demoForJSAlertsUrl"));
	}
	
	@Test
	public void actOnWindowAlert()
	{
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys("123");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		String expected = "Do you really want to delete this Customer?";
		Assert.assertEquals(alert.getText(), expected);
		alert.accept();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
