package testData;

import org.testng.annotations.DataProvider;

public class LoginFunctionalityData {
	
	@DataProvider(name="negative login data")
	public String[][] negativeSignInData() {
		String[][] data = {{"test@gmail.com","abc123"},{"test12@gmail.com","efg456"}};
		return data;
		
	}

}
