package class4;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;
import utils.Constants;

public class DropDown extends utils.CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		utils.CommonMethods.setUp("chrome", utils.Constants.SYNTAX_URL);
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[4]/a")).click();
		
		//Single-Selected Dropdown Menu
			//clicking on drop down icon
		WebElement weekDD=driver.findElement(By.id("select-demo"));
		
		//Select Class. Selenium's API. To choose drop down elements
		Select select = new Select(weekDD);
		System.out.println("Is this a multi-selectable drop down list? "+select.isMultiple());
		
		/*
		 * How to choose elements?
		 * 1) .selectByIndex();
		 * 2) .selectByValue(); --->the value written in DOM. It could differ!!!!!!!!!
		 * 3) .selectByVisibleText();
		 *	
		 *	~Single-Selected DD cannot perform .deselect(); method !!!
		 */
		
		select.selectByIndex(2); 
		Thread.sleep(1000);
		select.selectByVisibleText("Thursday");
		Thread.sleep(1000);
		select.selectByValue("Monday");
		Thread.sleep(1000);
		
		
		//Multi-Selected Drop Down List
		WebElement multiDD=driver.findElement(By.id("multi-select"));
		Thread.sleep(1000);
		Select select2 = new Select(multiDD);
		Thread.sleep(1000);
		System.out.println("Is this a multi-selectable drop down list? " + select2.isMultiple());
		Thread.sleep(1000);
		
		select2.selectByIndex(0);
		select2.selectByIndex(1);
		select2.selectByIndex(2);
		Thread.sleep(2000);
		select2.deselectAll();
		
		//how to retrieve all of the elements in a drop down? --> select.getOptions();
		List<WebElement> elements=select.getOptions();	
		for(WebElement myElement:elements) {
			System.out.print(myElement.getText() + " ");
		}
	}
}
