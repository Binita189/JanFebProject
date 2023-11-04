package testNGbasics;

import org.testng.annotations.DataProvider;

public class DataProvidingClass {
	
	@DataProvider(name="negative login data")
	public String[][] negativeSignInData() {
		String[][] data = {{"test@gmail.com","abc123"},{"test12@gmail.com","efg456"}};
		return data;
		
	}

}
