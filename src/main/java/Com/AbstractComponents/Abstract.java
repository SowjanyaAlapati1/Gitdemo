package Com.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

public class Abstract {
	WebDriver driver;
	public Abstract(WebDriver driver) {
	
		this.driver=driver;
		
	}
	
		
	public void elementToBeAppear(By locator) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void waitForelementToBeAppear(WebElement locator) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(locator));
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
	}
public void sendkeys(String text) {
	Actions a=new Actions(driver);
	a.sendKeys(text).build().perform();
	
}

public void close() {
driver.close();
}
}

