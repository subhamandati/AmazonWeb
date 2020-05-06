package com.freecrm.pages;

import org.testng.annotations.Test;

import com.amazon.AmazonWeb.BasePage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class CrmTestCases extends BasePage{
	@BeforeMethod
	  public void beforeMethod() throws Exception {
		  init();
		  launch("chrome");
	  }
	
	@Test
  public void f() throws InterruptedException {
	 HomePage homepage = new HomePage(driver);
	 ContactsPage contactspage = new ContactsPage(driver);
	 RegistrationPage registrationPage = new RegistrationPage(driver);
	 LoginPage loginPage = new LoginPage(driver);
	 ContactsDetailsPage contactDetailsPage = new ContactsDetailsPage(driver);
	 
	 homepage.login();
	 loginPage.login();
	 contactspage.visitContacts();
	 String row_data = contactspage.selectContact("rohith gunampalli");
	System.out.println("in test case" + row_data);
	contactspage.getUserEmail("rohith gunampalli");
	contactspage.getUserStatus("rohith gunampalli");
	contactspage.getUserPhone("rohith gunampalli");
	contactspage.getTableHeaders();
	contactspage.getRowCount();
	contactspage.getColumnCount();
	Thread.sleep(5000);
	contactDetailsPage.getCategory();
	contactDetailsPage.getStatus();
	
  
  }
  

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
  }

}
