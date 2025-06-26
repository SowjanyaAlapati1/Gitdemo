package Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.AbstractComponents.Abstract;

public class Homepage extends Abstract{
	WebDriver driver;
	
	public Homepage(WebDriver driver) {
	super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//button[@class='btn btn-custom'])[last()-1]")
	public WebElement cart;

	@FindBy(xpath = "//div[contains(@class,'col-lg-4')]")
	public List<WebElement> products;
	By productsBy = By.xpath("//div[contains(@class,'col-lg-4')]");
	
	By productnames = By.xpath("//b[text()='ZARA COAT 3']");
	
	By addtocart = By.xpath("(//button[@class='btn w-10 rounded'])[1]");
	
	By toastcontainer = By.id("toast-container");
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	public WebElement getorders;

	
		public List<WebElement> getProductslIst() {
		elementToBeAppear(productsBy);
		return products;
		
	}
	public WebElement getProductByName(String productname) {
		WebElement prod = getProductslIst().stream().filter(
				product -> product.findElement(productnames).getText().equalsIgnoreCase(productname))
				.findFirst().orElse(null);
		return prod;

	}
	public void clickproduct(String productname) {
		getProductByName(productname).findElement(addtocart).click();
		elementToBeAppear(toastcontainer);

	}
	public Cartpage addcart() {
		cart.click();
		Cartpage cartpage = new Cartpage(driver);

		return cartpage;
	}
	public orderspage getorders() {
		getorders.click();
		orderspage orderspage=new orderspage(driver);
		return orderspage;
		
		}
	
	
	
	
	

}
