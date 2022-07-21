package com.framework.webdrivers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.framework.reports.ExtentReportClass;
import com.framework.utlis.ReadProp;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverClass extends ExtentReportClass {

	// In this class we are going to maintain all the methods related to browser

	private WebDriver driver;
	 public static ThreadLocal<WebDriver> thread = new ThreadLocal<WebDriver>();
	
	//this method will be used to launch browser
	@BeforeMethod(alwaysRun = true)
	public void setupBrowser(String browser) throws IOException {
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else {
			Assert.fail("Invalid browser parameter is identified");
		}
		setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(ReadProp.readData("Config.properties").getProperty("Url"));
	}
	//This method will be used to close browser
		@AfterMethod(alwaysRun = true)
		public void teardownBrowser() {		
			driver.quit();
		}
		//method to store each browser session separately in the thread local
		public static synchronized void setDriver(WebDriver driver) {
			thread.set(driver);
		}
		//Method to share driver details with other classes
		public static synchronized WebDriver getDriver() {
			return thread.get();
		}
}
