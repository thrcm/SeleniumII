package class7;

import java.util.concurrent.TimeUnit;


import utils.CommonMethods;
import utils.Constants;

public class PageLaodAndImplicitWaits extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("Chrome", utils.Constants.SYNTAX_URL);
		
		//Selenium will wait 30 seconds for the page to be fully uploaded
		//if not, throws TimeOutException 
		//works after .get() or .navigate()
		//if user clicks on a link, it does not work
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		/*
		 * IMPLICIT WAIT : waits for ALL of the elements in your program to be found
		 * and/or processed within 10 seconds.
		 * if not, throws NoSuchElementException
		 * 
		 *  WORKS ONLY FOR findElement() and findElements();
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		
		driver.quit();
	}
}
