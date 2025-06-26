package com.Designframework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Testcomponents.BaseTest;

import org.testng.AssertJUnit;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Cartpage;
import Pageobjects.Checkoutpage;
import Pageobjects.Homepage;
import Pageobjects.Landingpage;
import Pageobjects.orderspage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandaloneTest extends BaseTest {
	String productname = "ZARA COAT 3";

	@Test(dataProvider = "getDataAs")
	public void submitOrder(HashMap<String, String> input) throws IOException {

		Homepage homepage = landpage.landapplication(input.get("email"), input.get("password"));

		List<WebElement> products = homepage.getProductslIst();
		
		homepage.clickproduct(productname);

		Cartpage cartpage = homepage.addcart();

		Boolean match = cartpage.checkproductname(productname);
		Assert.assertTrue(match);
		Checkoutpage checkout = cartpage.gotocheckout();

		checkout.selectcountry();
		checkout.placeorder();
		String actual = checkout.confirmmessage();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertTrue(actual.equalsIgnoreCase(expected));

	}
	//@Test
	public void invalidEmail() {
		Homepage homepage = landpage.landapplication("babykall@gmail.com", "Baby@123");

		List<WebElement> products = homepage.getProductslIst();
	}

	//@Test
	public void verifyorderlist() {
		String productname = "ZARA COAT 3";
		Homepage homepage = landpage.landapplication("babykalluri@gmail.com", "Baby@123");
		orderspage orderspage = homepage.getorders();
		List<WebElement> order = orderspage.getnamelist();
		Boolean name = orderspage.getdata(productname);
		Assert.assertTrue(name);

	}

//	@DataProvider
//	public Object[][] getemaildata() {
//		return new Object[][] { { "babykalluri@gmail.com", "Baby@123" }, { "anshika@gmail.com", "Iamking@000" } };
//
//	}
	
	@DataProvider
	public Object[][] getDataAs() {
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("email", "babykalluri@gmail.com");
		map.put("password", "Baby@123");
		
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("email", "anshika@gmail.com");
		map1.put("password", "Iamking@000");
		return new Object[][] {{map},{map1}};
	}

//		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'col-lg-4')]")));
//		List<WebElement> products = driver.findElements(By.xpath("//div[contains(@class,'col-lg-4')]"));
// Take the particular product name locater and apply gettext and find it or not
//		WebElement prod = products.stream().filter(
//				product -> product.findElement(By.xpath("//b[text()='ZARA COAT 3']")).getText().equals(productname))
//				.findFirst().orElse(null);
//		// To the taken product and then click on add to cart button
//		prod.findElement(By.xpath("(//button[@class='btn w-10 rounded'])[1]")).click();

	// w.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));

	// Click on cart
	// driver.findElement(By.xpath("(//button[@class='btn
	// btn-custom'])[last()-1]")).click();

	// Check the cart section items and added items are same or not
//		List<WebElement> itemspresent = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
//		Boolean match = itemspresent.stream().anyMatch(cartproduct->cartproduct.getText().equals(productname));
//		Assert.assertTrue(match);
	// click on checkout
	// driver.findElement(By.xpath("//button[text()='Checkout']")).click();

	// select country
	// WebElement sendata =
	// driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
//	Actions a=new Actions(driver);
//	a.sendKeys(sendata, "africa").build().perform();
//	List<WebElement> selectcountry = 	driver.findElements(By.xpath("//button[@class='ta-item list-group-item ng-star-inserted']"));
//		WebElement country = selectcountry.stream().filter(select->select.getText().equals("South Africa")).findAny().orElse(null);
//		country.click();
//		

	// driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
//		String actual = driver.findElement(By.xpath("//h1[text()=' Thankyou for the order. ']")).getText();
//		String expected = "THANKYOU FOR THE ORDER.";
//		Assert.assertEquals(actual, expected);

}
