package class8;

import java.util.Iterator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;
import utils.Constants;

public class WebTable extends utils.CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
		setUp("chrome", utils.Constants.SYNTAX_URL);
		
		//navigate to destination page
		driver.findElement(By.linkText("Table")).click();
		driver.findElement(By.linkText("Table Data Search")).click();
		
		//count of columns in header
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='task-table']/thead/tr/th"));
		System.out.println("Number of columns: " + columns.size());
		
		//printing out each column
		Iterator<WebElement> colIt=columns.iterator();		
		while(colIt.hasNext()) {
			String columnName = colIt.next().getText();
			System.out.print(columnName + " ");
		}
		
		//count of rows in body
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
		System.out.println("\nNumber of rows: " + rows.size());
		
		//printing out each row using Advanced For Loop
		for(WebElement rowData:rows) {
			String data=rowData.getText();
			System.out.println(data);
		}
		Thread.sleep(2000);
		
		//retrieving data cell by cell
		List<WebElement> rows2=driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr/td"));
		Iterator<WebElement> rows2It=rows2.iterator();
		while(rows2It.hasNext()) {
			String rowData=rows2It.next().getText();
			System.out.println(rowData);
		}
		Thread.sleep(2000);
		
		System.out.println("\n\n------Printing all of the cells out using for loop2-----------------");
		//How to find a specific element/data? Use for loop
		for(int i=1; i<=rows.size(); i++) {	//controlling ROWS. Be careful to not use rows2 since it calls cells, not rows
			for(int y=1; y<columns.size(); y++) { //controlling COLUMNS
				String dataCell = driver.findElement(By.xpath("//table[@id='task-table']/tbody/tr["+i+"]/td["+y+"]")).getText();  // use "" within tr[] and td[] as we put in String objects
				System.out.println(dataCell);
			}
		}
		
		
		
		driver.quit();
		
	}
}
