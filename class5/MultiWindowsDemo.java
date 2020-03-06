package class5;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class MultiWindowsDemo extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException {

		utils.CommonMethods.setUp("chrome", "https://www.google.com/gmail/about/#");
		
		//title of main page
		System.out.println("Title of first page: "+ driver.getTitle());
		
		//click on help-link to open up a separate window
		driver.findElement(By.linkText("Help")).click();
		Thread.sleep(1000);
		
		//windowHnadle() is required to acknowledge windows open
		Set<String> windowHandles= driver.getWindowHandles();
		System.out.println("Number of windows open: " + windowHandles.size());
		Thread.sleep(1000);
		
		//start off working on the second page in order to obtain ID of each window 	
		Iterator<String> it=windowHandles.iterator();
		String firstPage = it.next();
		String secondPage = it.next();
		
		//now, let's switch to new page by switchTo().window("windowHandle") and open it up
		Thread.sleep(1000);
		driver.switchTo().window(secondPage);
		Thread.sleep(1000);
		System.out.println("Title of the second page: " + driver.getTitle());
		
		//close both windows
		Thread.sleep(3000);
		driver.quit();
		
	}
}
