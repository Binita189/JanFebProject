package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasicScipts {

	public static void main(String[] args) throws InterruptedException {
		// 1. Browser / path of the driver
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		// 2. Instance/object of ChromeDriver pointing toward parent class WebDriver -> polymorphism
		WebDriver driver = new ChromeDriver();
		// maximizing browser  size
		driver.manage().window().maximize();
		// load application - url
		driver.get("https://www.amazon.com/");
		// Test script
		// pause execution - static wait
		Thread.sleep(5000);
		// for closing browser
		driver.close();

		

	}

}
