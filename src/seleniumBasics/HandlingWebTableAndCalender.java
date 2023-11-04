package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTableAndCalender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/index.php");
		
//		handle table
//		WebElement offerTable = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[4]"));
//		WebElement firstofferDestination = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[1]/td[1]/font"));
//		System.out.println(firstofferDestination.getText());
//		WebElement firstofferAmount = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[1]/td[2]/div/font"));
//		System.out.println(firstofferAmount.getText());
//		
//		WebElement secondofferDestination = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[2]/td[1]/font"));
//		System.out.println(secondofferDestination.getText());
//		WebElement secondofferAmount = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[2]/td[2]/div/font"));
//		System.out.println(secondofferAmount.getText());
		for(int i=1; 1<=5; i++) {
			WebElement offerDestination = driver.findElement(By.xpath("//table[@width='270']/tbody/tr["+i+"]/td[1]/font"));
			WebElement offerAmount = driver.findElement(By.xpath("//table[@width='270']/tbody/tr["+i+"]/td[2]/div/font"));
			System.out.println("OFFER"+i+":");
			System.out.println(offerDestination.getText()+" : "+offerAmount.getText());
		}
//		driver.close();
	}

}
