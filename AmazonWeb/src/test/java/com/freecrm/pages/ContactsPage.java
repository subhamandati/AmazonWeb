package com.freecrm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonWeb.BasePage;

public class ContactsPage extends BasePage {
	
	@FindBy(xpath="//span[text()='Contacts']/parent::a") WebElement contacts;
	
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void visitContacts()
	{
		waitForElement(60,contacts);
		contacts.click();
	}
	
	public String selectContact(String user) {
		String getContactData = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/parent::tr")).getText();
		System.out.println("In Page selectContact"+getContactData);
		return getContactData;
	}
	
	public String getUserEmail(String user) throws InterruptedException
	{
		String userEmail = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/parent::tr/td[7]")).getText();
		System.out.println("In Page getUserEmail"+userEmail);
		return userEmail;
	}
	
	public String getUserPhone(String user) throws InterruptedException
	{
		String userPhone = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/parent::tr/td[6]")).getText();
		System.out.println("In Page getUserPhone"+userPhone);
		return userPhone;
	}
	
	public String getUserStatus(String user) throws InterruptedException
	{
		String userStatus = driver.findElement(By.xpath("//td[contains(text(),'"+user+"')]/parent::tr/td[5]")).getText();
		System.out.println("In Page getUserStatus"+userStatus);
		return userStatus;
	}
	
	public void getTableHeaders()
	{
		List<WebElement> headers = driver.findElements(By.xpath("//table/thead/tr/th"));
		int headersCount = headers.size();
		System.out.println("Teable Headers count is :-" + headersCount);
		for(WebElement header:headers) 
		{
			System.out.println(header.getText());
		}
		
	}
	
	public int getRowCount()
	{
		List<WebElement> totalRows = driver.findElements(By.xpath("//table/tbody/tr"));
		int rowCount = totalRows.size();
		System.out.println("Rows Count is:-" + rowCount);
		return rowCount;	
		
	}
	
	public int getColumnCount()
	{
		List<WebElement> totalColumns = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		int colCount = totalColumns.size();
		System.out.println("Columns Count is:-" + colCount);
		return colCount;	
		
	}

	

}
