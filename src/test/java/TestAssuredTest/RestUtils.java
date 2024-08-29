package TestAssuredTest;



import org.apache.commons.lang3.RandomStringUtils;



public class RestUtils {

	public static String getFirstName() {
		String generateString = RandomStringUtils.randomAlphabetic(1);
		return("Arif"+generateString);
		
	}
	
	public static String getLastName() {
		String generateString = RandomStringUtils.randomAlphabetic(1);
		return("Hussain"+generateString);
		
	}
	
	public static String getUserName() {
		String generateString = RandomStringUtils.randomAlphabetic(3);
		return("Arif"+generateString);
		
	}
	
	public static String getPassword() {
		String generateString = RandomStringUtils.randomAlphabetic(3);
		return("Arif"+generateString);
		
	}
	
	public static String getEmail() {
		String generateString = RandomStringUtils.randomAlphabetic(3);
		return(generateString+"gmail.com");
		
	}
	
}
