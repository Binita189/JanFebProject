package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingRadioButtonAndCheckBox {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.ebay.com/");
//		driver.get("https:demo.guru99.com/test/newtours/register.php");
//		driver.get("https://www.amazon.com/");
//		driver.findElement(By.linkText("Flights")).click();
		
		//Handle Radio button
//		WebElement businessAccountRadioBtn = driver.findElement(By.id("businessaccount-radio"));
//		WebElement personalAccountRadioBtn = driver.findElement(By.id("personalaccount-radio"));
		
		//copying Xpath
//		WebElement onewayTrip = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table"
//				+ "/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]"));
		//copying Css selector 
//		WebElement roundTrip = driver.findElement(By.cssSelector("body > div:nth-child(5) > table > tbody > tr > td:nth-child(2) > table > tbody > "
//				+ "tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form >"
//				+ " table > tbody > tr:nth-child(2) > td:nth-child(2) > b > font > input[type=radio]:nth-child(1)"));
//		
//		Thread.sleep(5000);

//		onewayTrip.click();
		
//		Thread.sleep(5000);
		
//		roundTrip.click();
//		businessAccountRadioBtn.click();
//		Thread.sleep(5000);
//		personalAccountRadioBtn.click();
		
		driver.get("https://www.amazon.com/");
//		driver.findElement(By.id("icp-nav-flyout")).click();
//		WebElement spanishRadioBtn = driver.findElement(By.xpath("//*[@id=\"icp-language-settings\"]/div[3]/div/label/i"));
//		WebElement englishRadioBtn = driver.findElement(By.cssSelector("#icp-language-settings > div:nth-child(4) > div > label > i"));
		
//		Thread.sleep(5000);
//		spanishRadioBtn.click();
//		Thread.sleep(5000);
//		englishRadioBtn.click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.cssSelector("#ap_email")).sendKeys("test@gmail.com");
//		Thread.sleep(5000);
//		driver.findElement(By.id("continue")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.id("password")).click();
//		WebElement rememberMeCheckBx = driver.findElement(By.name("rememberMe"));
//		Thread.sleep(5000);
//		rememberMeCheckBx.click();
//		if(rememberMeCheckBx.isSelected()) {
//			System.out.println("Remember me check box test functionality: Passed");
//		}else {
//			System.err.println("Remember me check box test functionality: Failled");
//		}
//		Thread.sleep(5000);
//		
//		rememberMeCheckBx.click();
//		
//		if(!rememberMeCheckBx.isSelected()) {
//			System.out.println("Remember me check box test functionality: Passed");
//		}else {
//			System.err.println("Remember me check box test functionality: Failled");
//		}
//		Thread.sleep(5000);
//		
		
		//handling dropdown -> 1. Static Drop Down -> select tagName, select class -> a. visible txt b. index c. value of option 
		                    // 2. Dynamic drop down-> Mouse & keyboard operation
		                     
		
//		driver.findElement(By.xpath("//*[@id=\"searchDropdownBox\"]")).click();
		WebElement allDropDown = driver.findElement(By.id("searchDropdownBox"));
		Thread.sleep(5000);
		Select select = new Select(allDropDown);
		Thread.sleep(5000);
		// a. visible txt
//		select.selectByVisibleText("Amazon Devices");
//		Thread.sleep(5000);
//		select.selectByVisibleText("Amazon Pharmacy");
		// b. index 
//		select.selectByIndex(6);
//		Thread.sleep(5000);
//		select.selectByIndex(8);
//		Thread.sleep(5000);
		// c. value of option
//		select.selectByValue("search-alias=financial");
//		Thread.sleep(5000);
//		select.selectByValue("search-alias=gift-cards");
		
		for(int i=0; i<=10; i++) {
			select.selectByIndex(i);
			Thread.sleep(3000);
		}
//		Thread.sleep(5000);

		driver.close();
		

	}

}
