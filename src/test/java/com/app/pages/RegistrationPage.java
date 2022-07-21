package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.webdriver.WebDriverClass;

public class RegistrationPage extends WebCommons{

	By registrationPageHeaderTitle = By.xpath("//h1[@class='title']");
	
	@FindBy(xpath="//input[@name='customer.firstName']")
	private WebElement firstNamebox;
	
	@FindBy(xpath="//input[@name='customer.lastName']")
	private WebElement lastNamebox;
	
	@FindBy(xpath="//input[@name='customer.address.street']")
	private WebElement address;
	
	@FindBy(xpath="//input[@name='customer.address.city']")
	private WebElement city;
	
	@FindBy(xpath="//input[@name='customer.address.state']")
	private WebElement state;
	
	@FindBy(xpath="//input[@name='customer.address.zipCode']")
	private WebElement zipCode;
	
	@FindBy(xpath="//input[@name='customer.phoneNumber']")
	private WebElement phone;
	
	@FindBy(xpath="//input[@name='customer.ssn']")
	private WebElement ssn;
	
	@FindBy(xpath="//input[@name='customer.username']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@name='repeatedPassword']")
	private WebElement Password;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement conformPassword;
	
	@FindBy(xpath="//input[@value='Register']")
	private WebElement registerButton;
	
	@FindBy(xpath="//span[@class='error']")
	private List<WebElement> errors;
	
	By registrationSuccess = By.xpath("//h1[@class='title' and contains(text(),'Welcome')]");
	
	//actions
	public void verifyRegPage() {
		waitForLocator(registrationPageHeaderTitle);
		log("Successfully launched the registration page");
	}
	
	public void verifyRegistrationFeatures(String qwertyuiop,String qwertyuiop123) {
		enterInfo(firstNamebox,"firstNamebox");
		enterInfo(lastNamebox,"lastNamebox");
		enterInfo(address,"address");
		enterInfo(city,"city");
		enterInfo(state,"state");
		enterInfo(zipCode,"zipCode");
		enterInfo(phone,"phone");
		enterInfo(ssn,"ssn");
		enterInfo(Username,qwertyuiop);
		enterInfo(Password,qwertyuiop123);
		enterInfo(conformPassword,qwertyuiop123);
		click(registerButton);
		waitForLocator(registrationSuccess);
		log("Registration is successful");
	}
	public static RegistrationPage getRegistrationPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), RegistrationPage.class);
		
	}	
	
}
