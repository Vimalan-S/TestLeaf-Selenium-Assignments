package week2.day1.Assignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		// 1. Launch URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		// 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		// 5. Click on Leads Button 
		driver.findElement(By.linkText("Leads")).click();
		
		// 6. Click on create Lead Button 
		driver.findElement(By.linkText("Create Lead")).click();
			
		// 7. Enter CompanyName using id Locator 
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		//  8. Enter FirstName using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vimalan");
		
		// 9. Enter LastName using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("S");
		
		//  10. Enter FirstName(Local) Field Using id Locator 
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Vimal");
		
		// 11. Enter Department Field Using any Locator of Your Choice 
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("AutomationTesting");
		
		// 12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Beginner in Automation Testing");
		
		// 13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("vimalan.sekar.v1@gmail.com");
		
		// 14. Click on create Lead Button Using name Locator
		driver.findElement(By.name("submitButton")).click();
			   
		// 15. Get the Title of the resulting Page
		System.out.println("TITLE OF THE PAGE AFTER DUPLICATING CREATE LEAD:\n" + driver.getTitle());
			
		// 16. Click on Duplicate button 
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		// 17. Clear the CompanyName Field using .clear() And Enter new CompanyName
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Zoho");
		
		// 18.Clear the FirstName Field using .clear() And Enter new FirstName
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vimal");
		
		// 19.Click on Create Lead Button
		driver.findElement(By.name("submitButton")).click();
		
		// 20. Get the Title of Resulting Page using driver.getTitle()
		System.out.println("\nTITLE OF THE PAGE AFTER RENAMING CREATE LEAD:\n" + driver.getTitle());
	}
}
