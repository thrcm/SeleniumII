package class7;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;
import utils.Constants;

public class ExplicitWait extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", Constants.SYNTAX_URL);
		driver.findElement(By.linkText("All Examples")).click();
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Dynamic Data Loading")).click();
		driver.findElement(By.xpath("//button[text()='Get New User']")).click();
		
		//WebDriverWait=Explicit Wait --> waits for a particular web element loaded, or specified time is out
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("First-Name")));  //many many type of ExpectedCondition methods available
		
		//then, do the following
		boolean nameDisplayed = driver.findElement(By.id("First-Name")).isDisplayed();
		if(nameDisplayed) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		
		driver.close();
		
	}
}
