package week2.day1.Assignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

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
		
		// 10. Select value as Employee in Source Using SelectbyVisible text 
		WebElement src = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select obj = new Select(src);
		obj.selectByVisibleText("Employee");
		   
		// 11. Select value as Pay Per Click Advertising in MarketingCampaignId Using SelectbyValue
		WebElement marketing = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select marketingObj = new Select(marketing);
		marketingObj.selectByIndex(7);
		
		//  13. Select value as Corporation in OwnerShip field Using SelectbyIndex 
		WebElement owner = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownerObj = new Select(owner);
		ownerObj.selectByIndex(5);
		
		//  14. Select value as India in Country Field Using SelectbyVisibletext
		WebElement cntry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select cntryObj = new Select(cntry);
		cntryObj.selectByVisibleText("India");
		
		//  15. Click on create Lead Button Using name Locator
		driver.findElement(By.name("submitButton")).click();
		   
		//  16. Get the Title of the resulting Page
		System.out.println("TITLE OF THE PAGE AFTER CLICKING CREATE LEAD:\n" + driver.getTitle());
		
		//driver.close();
	}
}
