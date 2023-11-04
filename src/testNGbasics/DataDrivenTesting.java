package testNGbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Data Driven Testing
	// 1. @DataProvider -> data method returning data -> data will be handle in Array format
	// 2. "dataProvider" keyword in the test method will point to data providing method
	// 3. parameter in the test method and use in code

public class DataDrivenTesting {
WebDriver driver;
	
	@BeforeClass
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
	}

	@AfterMethod(alwaysRun=true) 
	public void backToHomePage() {
		driver.findElement(By.id("nav-logo-sprites")).click();
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
	@Test(dataProvider="positiveSearchData", groups={"E2E Test","Regression Test"})
	public void positiveSearchFunctionalityTest(String product) {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com : "+product;
		// Assertion -> creating validation point
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains(product));
		Assert.assertFalse(!driver.getTitle().contains(product));
		
	}
	
	@DataProvider
	public String[] positiveSearchData() {
		String[] searchProduct = {"apple","orange", "samsung"};
		return searchProduct;
		
	}
	
	@Test(dataProvider="positiveMenuLinkData")
	public void positiveMenuLinkFunctionalityTest(String link){
		driver.findElement(By.linkText(link)).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com:"+link;
		// Assertion -> creating validation point
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(driver.getCurrentUrl().contains(link.replace(" ", "")));
		Assert.assertFalse(!driver.getTitle().contains(link));
		
	}
	
	
	@DataProvider
	public String[]positiveMenuLinkData(){
		String[] menuLink = {"apple","orange", "samsung"};
		return menuLink;
		
	}
		
	}


