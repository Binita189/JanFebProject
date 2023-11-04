package seleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementTypesAndLocationStrategy {
	
	//  Selenium Automation 
		// 1. Locate the element (WebElement/WebObject/GUI Graphical User Interface)object or element)
		// 2. perform action
		// 3. validate action performed
	// WebElement or WebObjects or GUI (Graphical User Interface) objects or elements:
		//Types:
			// 1. Text Box/Field: user can input some characters
			// 2. Button/Tab: user input to click on it
			// 3. Radio Button: user input to click to select, "Round button"
			// 4. Check Box: user input to click to select, "Check mark"
			// 5. Links: click takes user to different page or application
			// 6. Text: to provide informations
			// 7. Drop Down; clicking on it more options are visible -> Static or Dynamic
			// 8. Menu/Menu links high value/feature/product/flow
			// 9. pictures/videos:
	

	
	// Strategy to locate WebElement:
		// Types:
			// 1. Name: value pointed mostly are unique. most commonly used
			// 2. ID: value pointed mostly are unique. most commonly used
			// 3. linkText: text of the link itself
			// 4. partial linkText: unique portion of the link
			// 5. ClassName: mostly not unique value, mostly not helpful to identify an element alone
			// 6. tagName: generic name, not able to identify an element, but helps to identify group of element
			// 7. Xpath: can be used when nothing works, copy or customizable
			// 8. Css selector: can be used when nothing works, copy or customizable
	
	// understanding DOM:
	// <input type="text" name="userName" size="10">
		// 1. tagName - input
		// 2. attribute - type/name/size
		// 3. value - text/ userName/10
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/binitarai/Downloads/chromedriver_mac_arm64/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://demo.guru99.com/test/newtours/index.php");
		driver.get("https://www.amazon.com/");
		Thread.sleep(5000);
		
		// identify element -> Name and ID
//		WebElement userNameTextField = driver.findElement(By.name("userName"));
//		userNameTextField.sendKeys("test"); // action on element
//		Thread.sleep(3000);
//		WebElement passwordTextField = driver.findElement(By.name("password"));
//		passwordTextField.sendKeys("123");
//		Thread.sleep(3000);
//	    driver.findElement(By.name("submit")).click();
	    
	    // creating verification point
//	    String expectedLoginSuccessPageUrl = "https://demo.guru99.com/test/newtours/login_sucess.php";
//	    String actualLoadingSuccessPageUrl = driver.getCurrentUrl();
//	    if (actualLoadingSuccessPageUrl.equals(expectedLoginSuccessPageUrl)){
//	    	System.out.println("Positive login functionality test: passed ");
//	    }else {
//	    	System.err.println("Positive login functionality test: Faild");
//	    }
	    
	    // handling linkText 
//	    driver.findElement(By.linkText("SIGN-OFF")).click();
//	    Thread.sleep(3000);
//	    driver.findElement(By.linkText("REGISTER")).click();
//	    String expectedRegisterPageTitle = "Register: Mercury Tours";
//	    String actualRegisterPageTitle = driver.getTitle();
//	    if(actualRegisterPageTitle.equals(expectedRegisterPageTitle)){
//	    
//	    	System.out.println("Register link functionality test: passed");
//	    	
//	    }else{
//	    	
//	    	System.err.println("Register link functionality test: Failed");
//	    }
		
		// Using ID strategy
		
		String productToSearch = "apple";
		WebElement searchTxtField = driver.findElement(By.id("twotabsearchtextbox"));
		searchTxtField.sendKeys(productToSearch);
	    driver.findElement(By.id("nav-search-submit-button")).click();
	    String actualProductSearchPageUrl = driver.getCurrentUrl();
	    if(actualProductSearchPageUrl.contains(productToSearch)) {
	    	System.out.println("Search functionality test: Passed");
	    }else {
	    	System.err.println("Search functionality test: Faild");
	    }
		
	    
	    Thread.sleep(3000);
		
		driver.close();		

	}

	}
