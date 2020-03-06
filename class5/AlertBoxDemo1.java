package class5;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import utils.CommonMethods;
import utils.Constants;

public class AlertBoxDemo1 extends utils.CommonMethods{

	/*
	 * If website is NOT HTML based, but JavaScript,'
	 * alert boxes cannot be inspected.
	 * So, use Alert Interface... that has 4 methods (by .switchTo() method)
	 * 1) accept();
	 * 2) dismiss();
	 * 3) sendKeys();
	 * 4) getText();
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUp("chrome", Constants.SYNTAX_URL);
		
		driver.findElement(By.xpath("//a[text()='Alerts & Modals']")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Javascript Alerts")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
	
		//when alert box pops up in JS based UI, use Alert interface
		Alert alert = driver.switchTo().alert();
		Thread.sleep(1000);
		
		//get text written in alert box
		String alertMessage = alert.getText();
		System.out.println("Alert box: "+ alertMessage);
		Thread.sleep(1000);
		
		//click on OKAY/YES/ACCEPT buttons in alert box
		alert.accept();
		Thread.sleep(1000);
		
		// JS CONFIRM BOX. It asks, hey you accept or deny/ yes or no etc
		driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		Thread.sleep(1000);
		
		String alertConfirmation = alert2.getText();
		System.out.println("Alert Confirmation Box: "+ alertConfirmation);
		
		alert2.dismiss();
		Thread.sleep(1000);
		
		
		/*
		 * When a prompt box pops up, user can click "OK" or "Cancel" to proceed.
		 * If the user clicks "OK" after entering the input value,
		 *  it will return value as Output. If the user clicks "Cancel" the box returns nothing
		 */
		
		driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']")).click();
		Thread.sleep(1000);
		
		Alert alert3 = driver.switchTo().alert();
		Thread.sleep(1000);
		String alertBox3 = alert3.getText();
		Thread.sleep(1000);
		System.out.println("Final Alert Box Message: " + alertBox3);
		
		String sendKeyWords = "seha&tahir";
		alert3.sendKeys(sendKeyWords);
		Thread.sleep(1000);
		alert3.accept();
		Thread.sleep(1000);
		
		String outputMessage = driver.findElement(By.id("prompt-demo")).getText();
		Thread.sleep(1000);
		System.out.println(outputMessage);
		Thread.sleep(1000);
		
		if(outputMessage.equals("You have entered '" + sendKeyWords + "' !")) {
			System.out.println("alert box works perfectly");
		}else {
			System.out.println("output message is not valid");
		}
		
		driver.close();
	}
}
