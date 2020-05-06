package com.listeners;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.amazon.AmazonWeb.BasePage;

public class Listeners extends BasePage implements ITestListener{

	public void onTestStart(ITestResult arg0) {
		
		Reporter.log("Test started Running:" +arg0.getMethod().getMethodName());
	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is Skipped:" +arg0.getMethod().getMethodName());
		
	} 
	
	public void onTestSuccess(ITestResult obj1) {
		if(obj1.isSuccess())
		{
			//Reporter.log("<a href='" + projectpath+"//success//"+filepath+".png" + "'> <img src='" + projectpath+"//success//"+filepath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has success : "+ obj1.getMethod().getMethodName());
		}
		
	}

	public void onTestFailure(ITestResult obj1) {

		if(!obj1.isSuccess())
		{
			try {
				File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileHandler.copy(srcfile, new File(projectpath+"//failure//"+filepath+".png"));
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			Reporter.log("<a href='" + projectpath+"//failure//"+filepath+".png" + "'> <img src='" + projectpath+"//failure//"+filepath+".png" + "' height='100' width='100'/> </a>");
			Reporter.log("Test has success : "+ obj1.getMethod().getMethodName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
