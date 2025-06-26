package Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.AbstractComponents.Abstract;

public class orderspage extends Abstract {
	public WebDriver driver;
	
	public orderspage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//tbody/tr/td[2]")
	public List<WebElement> ordersname;
	
	
	public List<WebElement> getnamelist() {
		return ordersname;
	}

	public Boolean getdata(String productname) {
		Boolean names = getnamelist().stream().anyMatch(name->name.getText().equalsIgnoreCase(productname));
		return names;
	}
}
