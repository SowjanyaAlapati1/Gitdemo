package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.AbstractComponents.Abstract;

public class Checkoutpage extends Abstract{
	WebDriver driver;
	public Checkoutpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Country']")
	public WebElement country;

	@FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted']")
	public List<WebElement> countryselection;

	@FindBy(xpath = "//a[text()='Place Order ']")
	public WebElement placeorder;

	@FindBy(xpath = "//h1[text()=' Thankyou for the order. ']")
	public WebElement thankyouorder;

	public void selectcountry() {
		
		country.sendKeys("africa");;
		WebElement countrysel = countryselection.stream().filter(select->select.getText().equals("South Africa")).findAny().orElse(null);
		countrysel.click();
		
	}
	public void placeorder() {
		placeorder.click();

	}
	public String confirmmessage() {
		String textmessage = thankyouorder.getText();
		return textmessage;
	}


}
