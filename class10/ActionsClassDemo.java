package class10;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import utils.CommonMethods;
import utils.Constants;

public class ActionsClassDemo extends utils.CommonMethods{

	/*
	 * Actions Class is used when mouse/keyboard does not work
	 * We have to finish each code line with .perform();
	 */
	
	public static void main(String[] args) throws InterruptedException {

		setUp("chrome", Constants.HRMS_URL);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		
		//instantiate Actions class
		Actions act = new Actions(driver);
		
		//move the focus to that element and then click
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		act.moveToElement(btnLogin).click().perform();
		//or, just click
		//act.click(btnLogin);
		
				
		//do right click
		//act.moveToElement(loginBtn).contextClick().perform();

		
		//hover an element
		WebElement timeLink = driver.findElement(By.linkText("Time"));
		act.moveToElement(timeLink).perform();
		Thread.sleep(3000);
		
		//to perform double click
		//act.moveToElement(btnLogin).doubleClick().perform();
		
		//act.keyUp(Keys.SHIFT).sendKeys("hello") --> if you perform this on txt box
				// it will hold shift key and type hello in upper case

		
		
	}
}
