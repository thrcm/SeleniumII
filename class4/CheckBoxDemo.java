package class4;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import utils.CommonMethods;
import utils.Constants;

public class CheckBoxDemo extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("firefox",Constants.HRMS_URL);
		CommonMethods.setUp("chrome", Constants.Google_URL);
		
		//check to see if login button works
		WebElement loginButton = driver.findElement(By.cssSelector("input[id='btnLogin']"));
		System.out.println("Login Button Works?: " + loginButton.isEnabled());
		
		//close the web page
		driver.close();
	}
}
