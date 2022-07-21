package com.framework.reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportClass {
	//This class will have methods to generate test results report 
	
	    public static ExtentReports extent;// to generate report
		public static ExtentTest test; // to print messages in the report
		
		//Method to start report
		@BeforeSuite(alwaysRun = true)
		public void starReporting() {
			ExtentHtmlReporter report = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\AutomationReport.html");
			extent = new ExtentReports();
			extent.attachReporter(report);
			test= extent.createTest("ProjectName","Parabank");
		}
		
		//method to stop reporting
		@AfterSuite(alwaysRun = true)
	public void stopReporting() {
		extent.flush();
	}
	
}
