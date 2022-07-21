package com.app.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.app.pages.ForgotPassPage;
import com.app.pages.LoginPage;
import com.app.pages.RegistrationPage;
import com.framework.utils.ReadExcel;
import com.framework.webdriver.WebDriverClass;

public class ApplicationTest extends WebDriverClass {

	
	@Test(priority=1,groups={"Smoke"})
	public void verifyLogo() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyLogo();
	}
	
	@Test(priority=0,groups= {"Smoke","Sanity"})
	public void verifyTitle() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyTitle();
	}
	
	@Test(priority=2,groups= {"Smoke"})
	public void verifyCaption() {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.verifyCaption();
	}
	
	@Test(priority=3,groups= {"Regression"},dataProvider="data")
	public void verifyRegistrationProcess(String qwertyuiop,String qwertyuiop123) {
		LoginPage loginpage = LoginPage.getLoginPage();
		RegistrationPage regpage =RegistrationPage.getRegistrationPage();
		loginpage.verifyRegistrationLink();
		regpage.verifyRegPage();
		regpage.verifyRegistrationFeatures(qwertyuiop, qwertyuiop123);	
	}
	
	@Test(priority=4,groups= {"Regression"},dataProvider= "data")
	public void verifyLoginFeature(String qwertyuiop,String qwertyuiop123) {
		LoginPage loginpage = LoginPage.getLoginPage();
		loginpage.loginIntoApplication(qwertyuiop, qwertyuiop123);
		
	}
	@Test(priority=5,groups= {"Regression","Sanity"})
	public void verifyForgotPassFeatures() {
		LoginPage loginpage = LoginPage.getLoginPage();
		ForgotPassPage forgotpass = ForgotPassPage.getForgotPassPage();
		loginpage.verifyForgotinfoLink();
		forgotpass.verifyForgotPassPage();
	}
	@DataProvider(name="data")
	public String[][] testData(){
		String[][] data = ReadExcel.readData("Data.xlsx", "TestData");
		return data;
		
	}
}
