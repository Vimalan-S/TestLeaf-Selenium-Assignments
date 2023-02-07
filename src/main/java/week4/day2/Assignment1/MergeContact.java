package week4.day2.Assignment1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//* 2. Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");		
		
		//* 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//* 4. Click on CRM/SFA Link
		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		//* 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//* 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//* 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		//* 8. Click on First Resulting Contact
		Set<String> allWh = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(allWh);
		driver.switchTo().window(lst.get(1));
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		//driver.close(); not required here
		driver.switchTo().window(lst.get(0));
		
		//* 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();

		//* 10. Click on Second Resulting Contact
		Set<String> allWh1 = driver.getWindowHandles();
		List<String> lst1 = new ArrayList<String>(allWh1);
		driver.switchTo().window(lst1.get(1));
		
		WebElement secWidget = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		driver.executeScript("arguments[0].click()", secWidget);
		//driver.close(); not required here
		driver.switchTo().window(lst.get(0));

		//* 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		//* 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//* 13. Verify the title of the page
		if(driver.getTitle().equals("View Contact | opentaps CRM")) System.out.println("TITLE: " + driver.getTitle());

	}
}
