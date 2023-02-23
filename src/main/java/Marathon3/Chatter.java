package Marathon3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Chatter extends ProjectSpecificMethod{

	@BeforeTest
	public void setup() {
		excelFile = "Chatter";
	}
	
	@Test(dataProvider = "fetchData")
	public void runChatter(String qn, String details) throws InterruptedException  {
//		5. Type Content on the Search box
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Content", Keys.ENTER);
		
//		6. Click Content Link 
		Thread.sleep(5000);
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		
//		7. Click on Chatter Tab 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("(//span[@class='slds-truncate'])[3]")));
		Thread.sleep(5000);
		
//		8. Verify Chatter title on the 
		if(driver.getTitle().contains("Chatter Home")) System.out.println("CHATTER HOME TITLE VERIFIED SUCCESSFULLY!\n");
		else System.err.println("Chatter Home Title verification failed :(");
		
//		9. Click Question tab 
		driver.findElement(By.xpath("(//span[@class='title'])[3]")).click();
		
//		10. Type Question with data (coming from excel) 
		driver.findElement(By.xpath("//textarea[@class='cuf-questionTitleField textarea']")).sendKeys(qn);
		
//		11. Type Details with data (coming from excel)
		driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys(details);
		
//		12. Click Ask 
		driver.findElement(By.xpath("//button[contains(@title, 'Click')]")).click();
		
//		13. Confirm the question appears 
		if(driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText().contains("Salesforce application")) System.out.println("QUESTION VERIFIED SUCCESSFULLY as: \n"+driver.findElement(By.xpath("(//span[@class='uiOutputText'])[3]")).getText());
		else System.err.println("Question verification failed :(");
		
	}
}
