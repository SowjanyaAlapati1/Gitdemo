package Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.AbstractComponents.Abstract;

public class Cartpage extends Abstract {
	WebDriver driver;
	public Cartpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
				
@FindBy(xpath  = "//div[@class='cartSection']/h3")
public List<WebElement> itemspresent;

@FindBy(xpath ="//button[text()='Checkout']")
public WebElement checkout;
	

	
	
	public List<WebElement> cartsection() {
		return itemspresent;
	}
	public boolean checkproductname(String productname) {
		Boolean match = cartsection().stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
		return match;

	}
	public Checkoutpage gotocheckout() {
		checkout.click();
		Checkoutpage checkout=new Checkoutpage(driver);
		return checkout;
	}
	
	}
