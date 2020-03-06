package class3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo1 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://leetcode.com/accounts/login/");
		
		WebElement userName = driver.findElement(By.xpath("//input[@autocorrect='off' and @name='login']"));
		userName.sendKeys("admin");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value = '';", userName);
		
		//clear the input field
		//userName.clear();
		//userName.clear();
		userName.sendKeys("tahir");
		
		driver.findElement(By.cssSelector("input[data-cy='password']")).sendKeys("123456");
		driver.findElement(By.cssSelector("div[class='btn-content-container__214G']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")).click();
		
		WebElement errorMessage = driver.findElement(By.cssSelector("p[class='error-message__27FL']"));
		
		if(errorMessage.isDisplayed()) {
			//obtaining text
			String errorMes = errorMessage.getText();
			if(errorMes.equals("The username and/or password you specified are not correct.")) {
				System.out.println("correct error message displayed");
			}else {
				System.err.println("incorrect error message displayed");
			}
		}
		
	}
}
