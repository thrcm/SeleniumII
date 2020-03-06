package class4;

import java.util.Iterator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;
import utils.Constants;

public class RadioButtonGroupCheck extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException{
		
		utils.CommonMethods.setUp("chrome", utils.Constants.SYNTAX_URL);
		
		driver.findElement(By.xpath("//a[text()='Input Forms']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Checkbox Demo']/following::a[39]")).click();
		Thread.sleep(2000);
		
		//single check box demo
		WebElement singleCB = driver.findElement(By.id("isAgeSelected"));
		Thread.sleep(2000);
		if(!singleCB.isSelected()) {
			singleCB.click();
			String message = driver.findElement(By.id("txtAge")).getText();
			if(message.equals("Success - Check box is checked")){
				System.out.println("Message successfully displayed");
			}else {
				System.err.println("unsuccessful attempt");
			}
		}
		
		Thread.sleep(2000);
		
		//multiple check box demo
		WebElement checkAllButton = driver.findElement(By.id("check1"));
		Thread.sleep(2000);
		if(checkAllButton.isDisplayed()) {
			checkAllButton.click();
			Thread.sleep(2000);
			String uncheckAll = checkAllButton.getAttribute("value");
			Thread.sleep(2000);
			if(uncheckAll.equals("Uncheck All")) {
				System.out.println("all of the check boxes selected");
			}
		}
		
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")).click();
		Thread.sleep(2000);
		if(checkAllButton.isDisplayed()) {
			String checkAll = driver.findElement(By.id("check1")).getAttribute("value");
			Thread.sleep(2000);
			if(checkAll.equals("Uncheck All")) {
				System.out.println("Not all of the check boxes selected");
			}else {
				System.out.println("All of the boxes checked");
			}
		}
		
		Thread.sleep(2000);
		
		//check all of the boxes at once
		List<WebElement> groupCheckBox=driver.findElements(By.xpath("//input[@class='cb1-element']"));
		Thread.sleep(2000);
		if(!groupCheckBox.isEmpty()) {
			Thread.sleep(1000);
			Iterator<WebElement> it =groupCheckBox.iterator();
			while(it.hasNext()) {
				it.next().click();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
