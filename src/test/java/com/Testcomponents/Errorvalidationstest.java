package com.Testcomponents;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pageobjects.Cartpage;
import Pageobjects.Homepage;

public class Errorvalidationstest extends BaseTest{
	@Test(groups = {"regression"})
	public void LoginErrorValidation() {
		landpage.landapplication("sss@gmail.com", "pwd");
		String actual = landpage.geterrormessage();
		AssertJUnit.assertEquals(actual, "Incorrect email or password.");
		
	}


@Test(groups = {"smoke"},retryAnalyzer=Retry.class)
public void ProductErrorValidation() {
	String productname = "ZARA COAT 3";
	Homepage homepage = landpage.landapplication("babykalluri@gmail.com", "Baby@123");

	List<WebElement> products = homepage.getProductslIst();
	homepage.getProductByName(productname);
	homepage.clickproduct(productname);

	Cartpage cartpage = homepage.addcart();

	Boolean match = cartpage.checkproductname("zara");
	Assert.assertFalse(match);
	
}
}

