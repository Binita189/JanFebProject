package testNGbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataDrivenFromDifferentClass {
	
	
	WebDriver driver;
	
	String expectedSignInErrorMsg1 = "To better protect your account,"
			+ " please re-enter your password and then enter "
			+ "the characters as they are shown in the image below.";
	String expectedSignInErrormsg2 = "Your password is incorrect";
	
	
	@BeforeClass
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
	}

	@AfterMethod 
	public void backToHomePage() {
		driver.findElement(By.xpath("//i[@aria-label='Amazon']")).click();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	@Test(dataProviderClass = DataProvidingClass.class, dataProvider = "negative login data")
	public void negativeSignInFunctionalityTestClickingButton(String username, String password) {
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(username);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.name("password")).sendKeys(password);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name(password)).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		WebElement signInErrorMsg = driver.findElement(By.xpath("//span[@class='a-list-item']"));
		Assert.assertTrue(signInErrorMsg.isDisplayed());
//		String expectedSignInErrorMsg1 = "To better protect your account,"
//				+ " please re-enter your password and then enter "
//				+ "the characters as they are shown in the image below.";
//		String expectedSignInErrormsg2 = "Your password is incorrect";
		if (signInErrorMsg.getText().equals(expectedSignInErrorMsg1)) {
			Assert.assertEquals(signInErrorMsg.getText(), expectedSignInErrorMsg1);
		}else if(signInErrorMsg.getText().equals(expectedSignInErrormsg2)){
			Assert.assertEquals(signInErrorMsg.getText(), expectedSignInErrormsg2);
		}
	}
		
	
	
	@Test(dataProviderClass = testData.LoginFunctionalityData.class, dataProvider = "negative login data")
	public void negativeSignInFunctionalityTestHittingEnterKey(String username, String password) {
		driver.findElement(By.id("nav-link-accountList")).click();
		driver.findElement(By.id("ap_email")).sendKeys(username);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.name(password)).sendKeys(password);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("signInSubmit")).click();
		WebElement signInErrorMsg = driver.findElement(By.xpath("//span[@class='a-list-item']"));
		Assert.assertTrue(signInErrorMsg.isDisplayed());
		if(signInErrorMsg.getText().equals(expectedSignInErrorMsg1)) {
			Assert.assertEquals(signInErrorMsg.getText(), expectedSignInErrorMsg1);
		}else if(signInErrorMsg.getText().equals(expectedSignInErrormsg2)){
			Assert.assertEquals(signInErrorMsg.getText(), expectedSignInErrormsg2);
		}
	}
	
}


