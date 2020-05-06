package com.amazon.AmazonWeb;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistrationPage extends BasePage{
	
	@FindBy(xpath = "//a[@class='login']") WebElement login;
	@FindBy(id="email_create") WebElement custEmail;
	@FindBy(xpath="//form[@id='create-account_form']//span[1]") WebElement createAccount;
	@FindBy(id="id_gender1") WebElement titleGender;
	@FindBy(id="customer_firstname") WebElement custFname;
	@FindBy(id="customer_lastname") WebElement custLname;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	@FindBy(id="days") WebElement day;
	@FindBy(id="months") WebElement month;
	@FindBy(id="years") WebElement year;
	@FindBy(id="newsletter") WebElement newsletter;
	@FindBy(id="firstname") WebElement fname;
	@FindBy(id="lastname") WebElement lname;
	@FindBy(id="company") WebElement company;
	@FindBy(id="address1") WebElement address1;
	@FindBy(id="address2") WebElement address2;
	@FindBy(id="city") WebElement city;
	@FindBy(id="id_state") WebElement state;
	@FindBy(id="postcode") WebElement pincode;
	@FindBy(id="id_country") WebElement country;
	@FindBy(id="other") WebElement other;
	@FindBy(id="phone") WebElement homePhone;
	@FindBy(id="phone_mobile") WebElement mobilePhone;
	@FindBy(id="alias") WebElement alternateAddress;
	
	public CustomerRegistrationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void customerRegister()
	{
		login.click();
		waitForElement(60,custEmail);
		
		custEmail.sendKeys(dp.getProperty("fname")+dp.getProperty("lname")+randomNum()+dp.getProperty("domain"));
		System.out.println("Customer Email is : -" +custEmail.getAttribute("value"));
		createAccount.click();
		waitForElement(60,titleGender);
		
		WebElement gender = driver.findElement(By.className("clearfix"));
		List<WebElement> list = gender.findElements(By.className("radio"));
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getAttribute("id") + "------" +list.get(i).getAttribute("checked"));
		}
		
		//titleGender.click();
		//titleGender.isSelected();
		//titleGender.getAttribute("value");
		
		custFname.sendKeys("custer fname");
		System.out.println("Customer Fname is : -" +custFname.getAttribute("value"));
		
		/*custLname.sendKeys("custer fname");
		System.out.println("Customer Lname is : -" +custFname.getAttribute("value"));

		password.sendKeys("pwd");
		System.out.println(password.getAttribute("value"));
		
	
		Select select_date = new Select(day);
		select_date.selectByValue("20");
		System.out.println("selected date :-" +select_date.getFirstSelectedOption().getText());
		 
		Select select_month = new Select(month);
		select_month.selectByVisibleText("January ");
		System.out.println("selected month :-" +select_month.getFirstSelectedOption().getText());
		
		Select select_year = new Select(year);
		select_year.selectByValue("1989");
		System.out.println("Selected year :-" + select_year.getFirstSelectedOption().getText());
		
		newsletter.click();
		System.out.println(newsletter.getAttribute("value"));
		
		fname.sendKeys("fhss");
		System.out.println(" Fname is : -" +fname.getAttribute("value"));
		
		lname.sendKeys("sfbbjs");
		System.out.println(" Fname is : -" +lname.getAttribute("value"));
		
		company.sendKeys("new comp");
		System.out.println(" company is : -" +company.getAttribute("value"));
		address1.sendKeys("jp nagar");
		System.out.println(" address1 is : -" +address1.getAttribute("value"));
		address2.sendKeys("sfhdhs");
		System.out.println(" address2 is : -" +address2.getAttribute("value"));
		city.sendKeys("bangalore");
		System.out.println(" city is : -" +city.getAttribute("value"));
		
		Select sele_state = new Select(state);
		sele_state.selectByVisibleText("Delaware");
		String firsrele = sele_state.getFirstSelectedOption().getText();
		System.out.println("selected element" + firsrele);
		
		pincode.sendKeys("518002");
		System.out.println("Pincode is :-" + pincode.getAttribute("value"));
		
		Select select_country = new Select(country);
		select_country.selectByVisibleText("United States");
		String selected_country = select_country.getFirstSelectedOption().getText();
		System.out.println("Selected country:- " + selected_country);
		
		other.sendKeys("other test");
		System.out.println("Additional Information is :-" +other.getAttribute("value"));
		
		homePhone.sendKeys("kfkhsd");
		System.out.println("Home phone is :-" + homePhone.getAttribute("value"));
		
		mobilePhone.sendKeys("767sfgsg");
		System.out.println("Mobile phone is :-" + mobilePhone.getAttribute("value"));
		
		alternateAddress.sendKeys("alternat");
		System.out.println("alternateAddress is :-" + alternateAddress.getAttribute("value"));*/
	}
	
	public void table_data()
	{
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'subha mandati')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void mouse_hover()
	{
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("About us"))).build().perform();
		driver.findElement(By.linkText("Fleet")).click();
	}
	
	public void drad_and_drop()
	{
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		action.clickAndHold(driver.findElement(By.xpath("//id"))).moveToElement(driver.findElement(By.xpath("//elemt"))).release().build().perform();
		
	}
	public void fb_checkbox() 
	{
		List<WebElement> gender = driver.findElements(By.xpath("//label[@class='_58mt']"));
		for(int i=0; i<gender.size();i++)
		{
			WebElement local_element = gender.get(i);
			String value = local_element.getText();
			
			System.out.println("values of radio buttons are"+value);
			
			if (value.equalsIgnoreCase("custom"))
			{
				local_element.click();
				System.out.println(local_element.getText() +"is" + local_element.isSelected());
				break;
				
			}
		}
	}

}
