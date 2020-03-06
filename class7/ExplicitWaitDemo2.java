package class7;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

public class ExplicitWaitDemo2 extends utils.CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", "https://www.google.com/");
		
		//hey, Keys. interface --> brings keyboard functions
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("whole foods", Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h3[@class='LC20lb']")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Thread.sleep(2000);
		driver.findElement(By.linkText("Order Online")).click();
		driver.findElement(By.id("select-a-store")).click();
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("estore_form_state_select")));
		
		//then, do the following
		WebElement continueButton = driver.findElement(By.cssSelector("input[value='Continue']"));
		boolean isDisplayed = continueButton.isDisplayed();
		if(isDisplayed) {
			String text = continueButton.getAttribute("value");
			System.out.println("button:" + text);
		}else {
			System.out.println("button is not displayed");
		}
		driver.close();
	}
}
