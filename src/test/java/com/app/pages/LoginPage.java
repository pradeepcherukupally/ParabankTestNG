package com.app.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.commons.WebCommons;
import com.framework.utils.ReadProp;
import com.framework.webdriver.WebDriverClass;

public class LoginPage extends WebCommons {
	
	//LoginPage WebElements
	
	@FindBy(xpath="//img[@class='logo']")
	private WebElement logo;
	
	@FindBy(xpath="//p[text()='Experience the difference']")
	private WebElement caption;
	
	@FindBy(xpath="//h2")
	private WebElement loginPageHeader;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement usernameTextbx;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@class='button']")
	private WebElement loginButton;
	
	By accountOverview = By.xpath("//h1[text()='Accounts Overview']");
	
	@FindBy(xpath="//a[text()='Forgot login info?']")
	private WebElement forgotInfolink;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement resgistrationLink;
	
	
	//actions
	
	public void verifyLogo() {
		Assert.assertTrue(logo.isDisplayed());
	}
	
	public void verifyTitle() {
		Assert.assertEquals(getTitle(), ReadProp.readData("Config.properties").getProperty("Title"));
		log("title is avaliable");
	}
	
	public void verifyCaption() {
		Assert.assertEquals(getElementText(caption), ReadProp.readData("Config.properties").getProperty("Caption"));
		log("caption is avaliable");
	}
	
	public void loginIntoApplication(String qwertyuiop,String qwertyuiop123 ) {
		enterInfo(usernameTextbx,qwertyuiop);
		enterInfo(passwordTextbox,qwertyuiop123);
		click(loginButton);
		waitForLocator(accountOverview);
		log("login is succesfull");
	}
	
	public void verifyRegistrationLink() {
		click(resgistrationLink);
	}
	
	public void verifyForgotinfoLink() {
		click(forgotInfolink);
	}
	
	
	public static LoginPage getLoginPage() {
		return PageFactory.initElements(WebDriverClass.getDriver(), LoginPage.class);
	}
	
	
	
	

}
