package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
public class MouseAndKeyboardOperation {
	
//	 Mouse & Keyboard operation -> Action class
	//1. Instance of Actions class -> pass driver
	//2. Find element
	//3. Build then perform action 


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		Actions action = new Actions(driver);
		WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
		
		// Mouse operation
		Thread.sleep(3000);
		action.moveToElement(accountList).build().perform();
		
		Thread.sleep(3000);
		action.moveToElement(driver.findElement(By.linkText("Account"))).click().build().perform();
		System.out.println(driver.getTitle());
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		Thread.sleep(3000);
		action.moveToElement(searchBox).click().sendKeys("apple").build().perform();
		action.doubleClick().build().perform();
		action.click().build().perform();
		
		// keyboard operation
		action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(3000);
		for(int i=1; i<=8; i++) {
			action.sendKeys(Keys.PAGE_DOWN).build().perform();
		}
		

		Thread.sleep(3000);
		for(int i=1; i<=8; i++) {
			action.sendKeys(Keys.PAGE_UP).build().perform();
		}
		
		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).doubleClick().sendKeys(Keys.DELETE).build().perform();
		
		Thread.sleep(3000);
		driver.close();

	}

}
