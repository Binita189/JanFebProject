package seleniumBasics;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationConcept {
	// Synchronization -> synch between application loading and automation execution 
	
	// Types of synchronization:
		//1. Static wait -> Thread.sleep(5000);
	
		//2. Dynamic wait -> pause execution for defined amount of time until element is found, if found continue execution
			// a. Implicit wait: -> global wait, defined once applicable for all elements where action is going to be performed
			// b. Explicit wait: -> defined for a specific element
	
				//Fluent wait: -> pooling/frequency of search can be adjusted
	
	// 0-5-10-15-20 --- 20sec ---- 3|11|16=10sec wastage
	// 0-2-4-6-8-10-12-14-16-18-20 ----- 20sec ------- 3|11|16|=2sec wastage

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		// implicit wait 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //(15, TimeUnit.SECONDS) -> (Duration.Ofseconds(15))
		
		Actions action = new Actions(driver);
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		
		Thread.sleep(3000); // static wait
		action.moveToElement(accountList).build().perform();
		
		// explicit wait
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement primeMenuOption = driver.findElement(By.id("nav-link-amazonprime"));
		explicitWait.until(ExpectedConditions.visibilityOf(primeMenuOption));
		explicitWait.until(ExpectedConditions.elementToBeClickable(primeMenuOption));
		action.moveToElement(primeMenuOption).build().perform();
		
		// Fluent wait
//		FluentWait<WebDriver> fl = new FluentWait<WebDriver>(driver)
			
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
