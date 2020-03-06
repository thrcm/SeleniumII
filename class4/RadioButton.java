package class4;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;
import utils.Constants;

public class RadioButton extends utils.CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		utils.CommonMethods.setUp("chrome", utils.Constants.SYNTAX_URL);
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		driver.findElement(By.linkText("Radio Buttons Demo")).click();
		WebElement maleRadioButton=driver.findElement(By.xpath("//input[@type='radio' and @value='Male' and @name='optradio']"));
		
		//check to see if male radio button is selected
		System.out.println("Before clicking on it; maleRadioButton: " + maleRadioButton.isSelected());
		Thread.sleep(2000);
		
		//click on it, and see if it is selected this time
		maleRadioButton.click();
		Thread.sleep(2000);
		System.out.println("After clicking on it; maleRadioButton: "+ maleRadioButton.isSelected());
		Thread.sleep(2000);
		
		System.out.println("************************************");
		
		//click on each one of the radio buttons
		List<WebElement> radioButtons=driver.findElements(By.xpath("//input[@name='optradio']"));
		for(int i=0; i<radioButtons.size(); i++) {
			WebElement singleRB = radioButtons.get(i);
			singleRB.click();
			System.out.println(singleRB.getAttribute("value") + " is selected? --> " + singleRB.isSelected());
			Thread.sleep(2000);
		}
		
		
		
		
	}
}
