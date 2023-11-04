package seleniumBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingIframDragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		
		// before handling iframe
//		WebElement draggableObject = driver.findElement(By.id("draggable")); // NoSuchElementException
		 
		// findElement() vs findElements()
		List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		System.out.println("Number of iframes: "+iframes.size());
		
		WebElement singleIframe = iframes.get(0);
//		String iframeTxt = singleIframe.getText();
		
		// switching to iframe
		driver.switchTo().frame(singleIframe);
//		driver.switchTo().frame(iframeTxt);
//		driver.switchTo().frame(0);
		
		// after handling iframe
		WebElement draggableObject = driver.findElement(By.id("draggable"));
		WebElement dropLocation = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		
		// Drag and drop operation
		// 1. 
//		action.moveToElement(draggableObject).build().perform();
//		action.clickAndHold().build().perform();
//		action.moveToElement(dropLocation).build().perform();
//		action.release().build().perform();
		
		// 2.
//		action.clickAndHold(draggableObject).build().perform();
//		action.release(dropLocation).build().perform();
		
		// 3.
//		action.clickAndHold(draggableObject).release(dropLocation).build().perform();
		
		// 4.
		action.dragAndDrop(draggableObject, dropLocation).build().perform();
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
