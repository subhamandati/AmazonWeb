package com.alertshandlig;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

public class FileUpload extends BasePage{
	
	@BeforeMethod
	public void setUp() throws Exception {
		init();
		launch("chrome", dp.getProperty("FileUploadUrl"));
		
	}
	
	@Test
	public void fileUpload() throws Exception {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[contains(text(),'Click here to add files')]")).click();
		Thread.sleep(3000);
		System.out.println("test");
		Runtime.getRuntime().exec("C:\\Users\\Dell\\Desktop\\fileupload.exe");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
