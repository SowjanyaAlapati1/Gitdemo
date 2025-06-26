package com.Testcomponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Pageobjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Landingpage landpage;

	public WebDriver intializedriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src/main//java//Resources//Globaldata.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			if(browsername.contains("headless")) {
				options.addArguments("headless");
				driver.manage().window().setSize(new Dimension(1440, 900));

			}
			driver = new ChromeDriver(options);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	public String getScreenshot(String testcasename, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "//reports//" + testcasename + ".png");
		
		FileUtils.copyFile(source, dest);
		return System.getProperty("user.dir") + "//reports//" + testcasename + ".png";

	}

	@BeforeMethod(alwaysRun = true)
	public Landingpage Launchapplication() throws IOException {
		driver = intializedriver();
		landpage = new Landingpage(driver);
		landpage.goTo();
		return landpage;

	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {
		driver.close();
	}

}
