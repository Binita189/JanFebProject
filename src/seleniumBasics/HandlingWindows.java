package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindows {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/windows");
		
		// getWindowHandle() vs getWindowHandles();
		String parentWindowHandle = driver.getWindowHandle();  //getWindowHandle()-> return window handle of a window under driver's control
		System.out.println("parent window handle: "+parentWindowHandle);
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Click Here")).click(); //new window will open
		driver.findElement(By.linkText("Click Here")).click();
		
		String oldWindowHandle = driver.getWindowHandle();
		System.out.println("Old windwo handle: "+oldWindowHandle);
		System.out.println("Still in old window? "+(parentWindowHandle.equals(oldWindowHandle)));
		
		//all windows
		Set<String> handles = driver.getWindowHandles(); //get windowHandle()-> return set of window handle of all window
		System.out.println("number of window opened: "+handles.size());
		Iterator<String> it = handles.iterator();
//		String window1Handle = it.next();
//		String window2Handle = it.next();
//		String window3Handle = it.next();
//		
//		System.out.println(window1Handle.equals(parentWindowHandle));
//		System.out.println(window1Handle.equals(parentWindowHandle));
		
		//switching window
//		driver.switchTo().window(window2Handle);
//		System.out.println("Title of window 2: "+driver.getTitle());
//		Thread.sleep(2000);
//		driver.close();
//		
//		driver.switchTo().window(window3Handle);
//		System.out.println("Title of window 3: "+driver.getTitle());
//		Thread.sleep(2000);
//		driver.close();
//		
//		driver.switchTo().window(window1Handle);
//		System.out.println("Title of window 1: "+driver.getTitle());
//		Thread.sleep(2000);
//		driver.close();
		
		while(it.hasNext()) {
			String handle = it.next();
			driver.switchTo().window(handle);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			driver.close();
		}
		
		
//		Thread.sleep(3000);
//		driver.close(); // close () -> window control by driver
//		driver.quit(); // Quite() -> close all the window opened by that driver instance 

	}

}
