package testNGbasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Assertion - to create validation point
	// verification vs validation -> will notify test case as pass of fail based on assertion -> 1. compare actual vs expected 2. actual is true 3. if actual is false
	
	 

public class UsingAnnotationsAndKeywords {
	WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
	}
	

//	@AfterMethod(alwaysRun=true) 
//	public void backToHomePage() {
//		driver.findElement(By.id("nav-logo-sprites")).click();
//	}
	
	@AfterMethod(alwaysRun=true) 
	public void tearDown() {
		
		driver.close();
	}
	
	@Test(groups={"Smoke Test","Regression  Test"})
	public void positiveSearchFunctionalityTest() {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com : apple";
		// Assertion -> creating validation point
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains("apple"));
		Assert.assertFalse(!driver.getTitle().contains("apple"));
		
	}
	
	@Test(groups={"Smoke Test","Integration Test","Regression Test"})
	public void positiveMenuLinkFunctionalityTest(){
		driver.findElement(By.linkText("Amazon Basics")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com: Amazon Basics";
		// Assertion -> creating validation point
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains("Amazon Basics"));
		Assert.assertFalse(!driver.getTitle().contains("Amazon Basics"));
		
	}
	
	@DataProvider
	public String[] positiveMenuLinkData() {
		String[]menuLink = {"amazone Basics","New Releases","Today's Deals"};
		return menuLink;
	}
	

}
