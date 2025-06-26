package com.Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	ExtentTest et;
	 ExtentReports er = ExtentReporterNG.getReporterObject();

	public void OnTestStart(ITestResult result) {
		et = er.createTest(result.getMethod().getMethodName());

	}

	public void OnTestSuccess(ITestResult result) {
		et.log(Status.PASS, "Test is passed");

	}

	public void OnTestFailure(ITestResult result) {
		et.fail(result.getThrowable());
		String filepath = null;
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		try {
	filepath = getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		et.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}
	public void OnFinish(ITestContext context) {
		
		er.flush();
	}
	

}
