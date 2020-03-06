package class8;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DynamicWebTableDemo {

	/*
	 * Open chrome browser
	 * Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
	 * Login to the application
	 * Verify customer “Susan McLaren” is present in the table
	 * Click on customer details
	 * Update product name
	 * Verify updated product name displayed in table
	 * Close browser
	 */
	
	public static void main(String[] args) throws InterruptedException {
		
		//do not be lazy. Try to remember how to setProperty()
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.manage().window().maximize();
		
		//logging in
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();

		//way to loop thru rows
		List<WebElement> row = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		
		//Verify customer “Susan McLaren” is present in the table. Do it by going row by row
		//The rows called in the above List starts with index number zero,but
		//rows in table starts with #1. Apply it in the below loop 
		String expectedValue = "Susan McLaren";
		for(int i=1; i<=row.size(); i++) {
			String rowData = row.get(i-1).getText();	//called each row
			if(rowData.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+1)+"]/td[1]")).click();
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+1)+"]/td[13]")).click();
				
				//drop down 
				WebElement dropDown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
				Select select = new Select(dropDown);
				select.selectByValue("FamilyAlbum");
				Thread.sleep(1000);
				//choose visa
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
				//click on UPDATE button
				driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
				Thread.sleep(2000);
				
				break;
				}
		}
		
		//check and see if it is updated
		String expectedProductName = "FamilyAlbum";
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
		for(int x=1; x<=rows.size(); x++) {
			String rowData = rows.get(x-1).getText();	//called each row
			if(rowData.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(x+1)+"]/td[1]")).click();
				Thread.sleep(1000);
				String productName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(x+1)+"]/td[3]")).getText();
				Thread.sleep(1000);
				if(productName.equals(expectedProductName)) {
					System.out.println("Product Name of chosen person is updated");
				}else {
					System.out.println("test failed");
				}
			}
			
		driver.close();
		
		}
		
	}
}
