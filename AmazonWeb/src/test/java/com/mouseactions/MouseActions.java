package com.mouseactions;

import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

import org.testng.annotations.BeforeMethod;

import java.awt.Window;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MouseActions extends BasePage{
  
	Actions a;
	@BeforeMethod
	  public void beforeMethod() throws Exception {
		init();
		launch("chrome", dp.getProperty("DragdROPurl"));
	  }
	@Test(enabled=false)
  public void autoSuggestion() throws InterruptedException {
		System.out.println("I am in google homw page");
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("subhashini");
		String inputString = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).getAttribute("value");
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']/li/div/div[2]/div/span"));
		
		Thread.sleep(3000);
		for(WebElement li :list)
		{
			if(li.getText().equals(inputString))
				li.click();
			return;
		}
		
		driver.findElements(By.xpath("//ul[@class='erkvQe']/li/div/div[2]/div/span"));
  }
	
	@Test(enabled=false)
	public void scrollDown()
	{
		for(int i=0; i<5; i++)
		{
		((RemoteWebDriver)driver).executeScript("window.scrollBy(0,100)");
		}
	}
	
	@Test(enabled=false)
	public void slider() {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement drag = driver.findElement(By.xpath("//div[@id='slider']/span"));
		a = new Actions(driver);
		//a.dragAndDropBy(drag, 300, 0).perform();
		a.clickAndHold(drag).moveByOffset(300, 0).release().build().perform();	
	}
	
	@Test (enabled = false)
	public void rightClick() {
		WebElement element = driver.findElement(By.xpath("//a[text()='Draggable']"));
		a= new Actions(driver);
		a.contextClick(element).perform();
		
	}
	
	@Test (enabled = false)
	public void resizeMethod() throws InterruptedException
	{
		driver.get("http://jqueryui.com/resizable/");
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement drag = driver.findElement(By.xpath("//div[@id='resizable']/div[3]"));
		a = new Actions(driver);
		//a.moveToElement(drag, 100, 200).perform();
		a.clickAndHold(drag).moveByOffset(100, 200).release(drag).build().perform();
		Thread.sleep(4000);
	}
	
	@Test
	public void dragAndDrop() {
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		a=new Actions(driver);
		a.dragAndDrop(drag, drop).perform();
		//a.clickAndHold(drag).moveToElement(drop).release(drag).build().perform();	
	}
	
	@Test (enabled = false)
	public void MoveToelement() throws InterruptedException
	{	
		driver.get("https://www.snapdeal.com");
		a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/span[1]"))).perform();
		driver.findElement(By.xpath("//*[@id='sdHeader']/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[1]/ul/li[1]/a")).click();
		Thread.sleep(3000);
	}
	
	
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
