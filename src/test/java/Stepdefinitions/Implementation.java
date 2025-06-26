package Stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.Testcomponents.BaseTest;

import Pageobjects.Cartpage;
import Pageobjects.Checkoutpage;
import Pageobjects.Homepage;
import Pageobjects.Landingpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Implementation extends BaseTest {
	public Landingpage landpage;
	public Homepage homepage;
	public Cartpage cartpage;
	public Checkoutpage checkout;

	@Given("user landed on website")
	public void user_landed_on_website() throws IOException {
		landpage = Launchapplication();

	}

	@Given("^user login to application with (.+) and (.+)$")
	public void user_login_to_application_with_emailid_and_password(String emailid, String password) {
		homepage = landpage.landapplication(emailid, password);

	}

	@When("^I add (.+) to cart$")
	public void I_add_productname_to_cart(String productname1) {
		List<WebElement> products = homepage.getProductslIst();
		//homepage.getProductByName(productname1);
		homepage.clickproduct(productname1);

	}

	@And("^click on checkout (.+) and submit the order$")
	public void click_on_checkout_and_submit_the_order(String productname1) {
				cartpage = homepage.addcart();
		Boolean match = cartpage.checkproductname(productname1);
		Assert.assertTrue(match);
		checkout = cartpage.gotocheckout();
	}

	@Then("THANKYOU FOR THE ORDER.message will displayed")
	public void THANKYOU_FOR_THE_ORDER_message_will_displayed() {
		checkout.selectcountry();
		checkout.placeorder();
		String actual = checkout.confirmmessage();
		String expected = "THANKYOU FOR THE ORDER.";
		Assert.assertTrue(actual.equalsIgnoreCase(expected));

	}

}
