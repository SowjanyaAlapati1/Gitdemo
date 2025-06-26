package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.AbstractComponents.Abstract;

public class Landingpage extends Abstract{
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id = "userEmail")
	public WebElement email;
	
	@FindBy(id="userPassword")
	public WebElement password;
	
	@FindBy(id= "login")
	public WebElement login;
	
	@FindBy(xpath ="//div[@aria-label='Incorrect email or password.']")	
	public WebElement incorrectpassword;
	
		
	public Homepage landapplication(String emailid, String passwrd) {
		email.sendKeys(emailid);
		password.sendKeys(passwrd);
		login.click();
		Homepage homepage = new Homepage(driver);
		return homepage;
	}
	public String geterrormessage() {
	 waitForelementToBeAppear(incorrectpassword);
		String errorvalidation = incorrectpassword.getText();
		return errorvalidation;
		
	}
}
