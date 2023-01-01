package week2.day1.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

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
		
		//  5. Click on Accounts Button 
		driver.findElement(By.linkText("Accounts")).click();
		
		//  6. Click on Create Account 
		driver.findElement(By.linkText("Create Account")).click();
		
		//  7. Enter AccountName Field Using Xpath Locator value as Debit Limited Account
		driver.findElement(By.xpath("//input[@id = 'accountName']")).sendKeys("Debit Limited Account");
		   
		//  8. Enter DEscriptiion as "Selenium Automation Tester" 
		driver.findElement(By.xpath("//textarea[@name = 'description']")).sendKeys("Selenium Automation Tester");
		
		//  9. Enter LocalName Field Using Xpath Locator 
		driver.findElement(By.xpath("//input[@id = 'groupNameLocal']")).sendKeys("Vimalan");
		
		//  10. Enter SiteName Field Using Xpath Locator 
		driver.findElement(By.xpath("//input[@id = 'officeSiteName']")).sendKeys("TestLeaf.com");
		
		//  11. Enter value for AnnualRevenue Field using Xpath Locator but class as Attribute 
		driver.findElement(By.xpath("//input[@class='inputBox' and @id='annualRevenue']")).sendKeys("200000");
		
		//  12. Select Industry as ComputerSoftware
		WebElement industry = driver.findElement(By.xpath("//select[@name='industryEnumId']"));
		Select industryObj = new Select(industry);
		industryObj.selectByVisibleText("Computer Software");
		
		//  13. Select OwnerShip as S-Corporation using SelectByVisibletext
		WebElement owner = driver.findElement(By.name("ownershipEnumId"));
		Select ownerObj = new Select(owner);
		ownerObj.selectByVisibleText("S-Corporation");
		
		//  14. Select Source as Employee using SelectByValue
		WebElement src = driver.findElement(By.id("dataSourceId"));
		Select srcObj = new Select(src);
		srcObj.selectByValue("LEAD_EMPLOYEE");
		
		//  15. Select Marketing Campaign as eCommerce Site Internal Campaign using SelectbyIndex
		WebElement marketing = driver.findElement(By.id("marketingCampaignId"));
		Select marketingObj = new Select(marketing);
		marketingObj.selectByIndex(6);
		
		//  16. Select State/Province as Texas using SelectByValue 
		WebElement state = driver.findElement(By.id("generalStateProvinceGeoId"));
		Select stateObj = new Select(state);
		stateObj.selectByValue("TX");
		
		//  17. Click on Create Account using Xpath Locator 
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();	
		
		//driver.close();
		}
}
