package week3.day1.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		
		// 8	Enter first name //input[@class = ' x-form-text x-form-field ' and @name='firstName']
		driver.findElement(By.xpath("//input[@class=' x-form-text x-form-field' and @name='firstName']")).sendKeys("Hema");
		//driver.findElement(By.xpath("//input[@class = ' x-form-text x-form-field ' and @name='firstName']")).click();
		
		// 9	Click Find leads button
		driver.findElement(By.xpath("//button[text() = 'Find Leads']")).click();
		Thread.sleep(2000);
		
		// 10 Click on first resulting lead
		driver.findElement(By.xpath("(//div[@class= 'x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
		
		// 11 Verify title of the page
		System.out.println(driver.getTitle());
		
		// 12 Click Edit 
		driver.findElement(By.xpath("(//div[@class= 'frameSectionExtra']/a)[3]")).click();
		
		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Zoho");
		
		// 14 Click Update
		driver.findElement(By.name("submitButton")).click();
		
		// 15 Confirm the changed name appears 
		String result = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if(result.contains("Zoho")) {
			System.out.println("Company Name changed successfully");
		}
		
		// 16 Close the browser (Do not log out)
		driver.close();
	}
}
