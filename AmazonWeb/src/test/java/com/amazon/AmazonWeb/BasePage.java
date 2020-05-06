package com.amazon.AmazonWeb;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;

	public static String projectpath = System.getProperty("user.dir");
	public static Properties dp;
	public static String filepath;
		
	
	static
	{
		Date dt = new Date();
		filepath= dt.toString().replace(' ', '_').replace(':', '_');
		
	}
	public void init() throws Exception
	{
		System.out.println(projectpath);
		FileInputStream fis = new FileInputStream(projectpath+"//data.properties");
		dp = new Properties();
		dp.load(fis);
	}
	
	public static void launch(String browser)
		{
			if(browser.equalsIgnoreCase("Chrome"))
			{
			System.setProperty("webdriver.chrome.driver", "E:\\Subhashini\\drivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.addArguments("user-data-dir=C:\\Users\\DELL\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 7");
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
			else
			{
				System.out.println("Please enter valid browser name");
			}
			  driver.manage().window().maximize();
			  driver.manage().deleteAllCookies();
			  driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			  driver.get("https://freecrm.co.in/");
		}
		
		public void waitForElement(int timeInSeconds, WebElement locator)
		{
			WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(locator));
		}
		
		public int randomNum()
		{
			Random r = new Random();
			int num = r.nextInt(99999);
			return num;
			
		}
}
