package class7;

import utils.CommonMethods;
import utils.Constants;

public class TestAlertFunction extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		//driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		//driver.findElement(By.linkText("Radio Buttons Demo")).click();
		//WebElement maleRadioButton=driver.findElement(By.xpath("//input[@type='radio' and @value='Male' and @name='optradio']"));
		
		
		//adding ALERT functions here
		String textAlert = getTextFromAlert();
		System.out.println(textAlert);
				
		acceptAlert();
				
		
		
		//check to see if male radio button is selected
		//System.out.println("Before clicking on it; maleRadioButton: " + maleRadioButton.isSelected());
		Thread.sleep(2000);
		
		driver.close();
			
		
	}
}
