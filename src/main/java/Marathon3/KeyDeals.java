package Marathon3;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KeyDeals extends ProjectSpecificMethod {
	
	@BeforeTest
	public void setup() {
		excelFile = "KeyDeals";
	}
	
	@Test(dataProvider = "fetchData")
	public void runKeyDeals(String oppName, String amt) throws InterruptedException{
//		3. click Sales from App Launcher 
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
//		4. Click View All Key Deals in Key Deals  
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[4]")));
		
//		6. Click on New 
		driver.findElement(By.xpath("//a[@title='New']")).click();
		
//		7. Give Opportunity Name  (From Excel) 
		driver.findElement(By.xpath("(//label[text()='Opportunity Name']//following::input[@class='slds-input'])[1]")).sendKeys(oppName);
		
//		8. Select Type as New Customer and Lead Source as Partner Referral  
		driver.findElement(By.xpath("(//label[text()='Type']//following::div)[1]")).click();
		driver.findElement(By.xpath("//span[@title='New Customer']")).click();
		
		driver.findElement(By.xpath("(//label[text()='Lead Source']//following::div)[1]")).click();
		driver.findElement(By.xpath("//span[@title='Partner Referral']")).click();
		
//		9. Give Amount as 75000 (from Excel)
		driver.findElement(By.xpath("(//label[text()='Amount']//following::input[@class='slds-input'])[1]")).sendKeys(amt);
		
//		10. Select Close Date as tomorrow 
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click(); 
		driver.findElement(By.xpath("(//span[@class='slds-day'])[27]")).click();
				
//		11. Select Stage as Needs Analysis 
		driver.findElement(By.xpath("(//label[text()='Stage']//following::div)[1]")).click();
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
//		12. Click in Primary Campaign  Source and Select first option  
		driver.findElement(By.xpath("//input[contains(@placeholder, 'Campaigns')]")).click();
		Thread.sleep(4000);
		driver.executeScript("arguments[0].click();", driver.findElement(By.xpath("(//span[contains(@class, 'listbox__option')]//span[@class='slds-truncate'])[1]")));
		
//		13. Click Save and Verify the opportunity is created" 
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[contains(@class, 'toastMessage')]")).getText());

	}
}
