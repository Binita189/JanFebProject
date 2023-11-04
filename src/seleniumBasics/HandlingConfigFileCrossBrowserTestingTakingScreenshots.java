package seleniumBasics;

import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.FluentWait;

public class HandlingConfigFileCrossBrowserTestingTakingScreenshots {
	static Properties prop;
	static WebDriver driver;

	public static void main(String[] args) {
		// Handling config.properties(configuration file/date)
		// 1. properties class -> call method to extract config data
		try {
			prop = new Properties();
			// 2. FileInputStream class -> read config.properties
			FileInputStream fis = new FileInputStream("/Users/binitarai/eclipse-workspace/JanFebBatch/src/seleniumBasics/config.properties");
			// 3. load all the value read to properties class
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// cross browser testing concept
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty(prop.getProperty("chromeKey"), prop.getProperty("chromePath"));
			driver = new ChromeDriver();

		}else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty(prop.getProperty("ffKey"), prop.getProperty("ffPath"));
			driver = new FirefoxDriver();
			
		}else if(prop.getProperty("browser").equalsIgnoreCase("msedge")) {
				System.setProperty(prop.getProperty("edgeKey"), prop.getProperty("edgePath"));
				driver = new EdgeDriver();
		}else {
			System.err.println(prop.getProperty("notSupportedBrowser"));
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
	
		
//				driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //(15, TimeUnit.SECONDS) -> (Duration.Ofseconds(15))
				
				Actions action = new Actions(driver);
				WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
				
				action.moveToElement(accountList).build().perform();
				
				//screenshot1
				
				File screenshot1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screenshot1, new File("/Users/binitarai/eclipse-workspace/JanFebBatch/src/seleniumBasics/screenshot1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // common IOpackage -> https://commons.apache.org/proper/commons-io/
				
//				Thread.sleep(3000); // static wait
//				action.moveToElement(accountList).build().perform();
				
			
				WebDriverWait explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));
				WebElement primeMenuOption = driver.findElement(By.id("nav-link-amazonprime"));
				explicitWait.until(ExpectedConditions.visibilityOf(primeMenuOption));
				explicitWait.until(ExpectedConditions.elementToBeClickable(primeMenuOption));
				action.moveToElement(primeMenuOption).build().perform();
				
				//screenshot2
				
				File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screenshot2, new File("/Users/binitarai/eclipse-workspace/JanFebBatch/src/seleniumBasics/screenshot2.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//			
				FluentWait<WebDriver> fl = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(Long.valueOf(prop.getProperty("implicitWaitDuration"))))
						.pollingEvery(Duration.ofSeconds(Long.valueOf(prop.getProperty("fluentWaitPollingDuration"))))
						.ignoring(NoSuchElementException.class);
				WebElement flagIcon = driver.findElement(By.id("icp-nav-flyout"));
				fl.until(ExpectedConditions.presenceOfElementLocated(By.id("icp-nav-flyout")));
				action.moveToElement(flagIcon).build().perform();
				
				//screenshot3
					
				File screenshot3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screenshot3, new File("/Users/binitarai/eclipse-workspace/JanFebBatch/src/seleniumBasics/screenshot3.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// screenshot of element
				
				File screenshot4 = flagIcon.getScreenshotAs(OutputType.FILE);
				try {
					FileUtils.copyFile(screenshot3, new File("/Users/binitarai/eclipse-workspace/JanFebBatch/src/seleniumBasics/screenshot4.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.close();
		

	}

}
