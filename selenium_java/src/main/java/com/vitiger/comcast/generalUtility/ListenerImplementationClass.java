package com.vitiger.comcast.generalUtility;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * this class gives the implementation for the listener
 * @author aman
 *
 */
public class ListenerImplementationClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"==========================>start");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodnmae = result.getMethod().getMethodName();
		System.out.println(methodnmae+"==================>execution successful");
		
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName);
		System.out.println(result.getThrowable());
		
			 try {
				
				String path = new WebDriverUtility().takeScreenshot(BaseClass.sdriver, methodName);
			} catch (Throwable e) {
			
				e.printStackTrace();
			}
			

		 
		
	}

	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println(methodname);
		System.out.println(result.getThrowable());
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		System.out.println(context);
		
	}

	public void onFinish(ITestContext context) {
		System.out.println(context);
		
	}
	
	
	

}
