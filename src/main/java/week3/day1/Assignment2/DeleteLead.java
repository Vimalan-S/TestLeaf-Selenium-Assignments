package week3.day1.Assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// 1	Launch the browser
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		driver.manage().window().maximize();
		
		// 2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// 3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();
		
		// 7	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//8	Click on Phone 
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		
		//9	Enter phone number 
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("0123456789");
		
		//10	Click find leads button 
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		//11	Capture lead ID of First Resulting lead 
		Thread.sleep(2000);
		String str = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).getText();
		System.out.println("First Lead: "+str);
		
		//12	Click First Resulting lead
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();
		
		//13	Click Delete 
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		
		//14	Click Find leads
		driver.findElement(By.linkText("Find Leads")).click();
		
		//15	Enter captured lead ID 
		driver.findElement(By.xpath("//div[@class='x-form-element']/input[@name='id']")).sendKeys(str);
		
		//16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(10000);
		
		//17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String result = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(result);
		if(result.equals("No records to display")) {
			System.out.println("Successfull Deletion");
		}
			
		//18	Close the browser (Do not log out)
		driver.close();
	}
}
