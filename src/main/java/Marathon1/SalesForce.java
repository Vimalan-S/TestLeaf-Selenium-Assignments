package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		        
		WebDriverManager.chromedriver().setup();
	
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//01) Login to https://login.salesforce.com
		driver.get("https://login.salesforce.com");
		
		driver.manage().window().maximize(); 

		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		
		driver.findElement(By.id("Login")).click();
		
		//	2. Click on toggle menu button from the left corner 
		driver.findElement(By.xpath("//button[contains(@class, 'salesforceIdentityAppLauncherHeader')]")).click();
		
		//	3. Click view All and click Sales from App Launcher 
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
		driver.findElement(By.xpath("//span/p[@class='slds-truncate' and text()='Sales']")).click();
		
		//	4. Click on Opportunity tab  
		WebElement opp = driver.findElement(By.xpath("(//span[text()='Opportunities'])[1]"));
		driver.executeScript("arguments[0].click()", opp);
		
		//	5. Click on New button
		driver.findElement(By.linkText("New")).click();
			
		//	6. Enter Opportunity name as 'Salesforce Automation by Your Name, 
		driver.findElement(By.xpath("//input[@name=\"Name\"]")).sendKeys("Salesforce Automation Vimalan");
		
		//	Get the text and Store it 
		String oppName = "Salesforce Automation Vimalan";
		
		//	7. Choose close date as Today 
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		
		//	8. Select 'Stage' as Need Analysis //button[@aria-label='Stage, --None--']
		//	9. click Save and VerifyOppurtunity Name"

	}
}
