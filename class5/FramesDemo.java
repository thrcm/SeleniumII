package class5;

import org.openqa.selenium.By;


import utils.CommonMethods;
import utils.Constants;

public class FramesDemo extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		driver.findElement(By.linkText("Others")).click();
		driver.findElement(By.linkText("Iframe")).click();
		
		//just getting a text written in MAIN PAGE
		String mainPageDisplay = driver.findElement(By.xpath("//h2[text()='IFrame practice']")).getText();
		System.out.println("Main Page Displays " + mainPageDisplay);
	
		//switching to frame
		driver.switchTo().frame("FrameOne");
		Thread.sleep(1000);
		
		String frame1 =driver.findElement(By.xpath("//div[@class='col-md-9 text-left']")).getText();
		Thread.sleep(1000);
		System.out.println("Frame1 displays " + frame1);
	
		//going back to main page
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		String mainPageDisplay2 = driver.findElement(By.xpath("//h2[text()='IFrame practice']")).getText();
		System.out.println("Main Page Displays2 " + mainPageDisplay);
		
		//going to parent Frame
		driver.switchTo().parentFrame();
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	} 
}
