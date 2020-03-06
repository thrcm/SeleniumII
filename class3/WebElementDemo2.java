package class3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.findElement(By.cssSelector("input[id*='txtUsername']")).sendKeys("VanceEddie");
		Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys("VanceEddie@&12");
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		
		
		//HOW MANY textLinks at the website? USING findElements()
		List<WebElement> linkList =driver.findElements(By.tagName("a"));
		System.out.println("Number of links: " + linkList.size());
		
		//what are the textLinks that have value on?
		System.out.println("List of Active textLinks: \n");
		for(WebElement myList:linkList) {
			String myText = myList.getText();
			if(!myText.isEmpty()) {
				System.out.println(myText);
			}
		}
		
		
		driver.close();
				
		
	}
}
