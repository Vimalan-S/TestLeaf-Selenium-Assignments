package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws IOException {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();
		
		//ChromeDriver driver = new ChromeDriver();
		
		// 1) Launch Salesforce application https://login.salesforce.com/
		driver.get("https://login.salesforce.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
//		2) Login with username as "hari.radhakrishnan@qeagle.com" and password as "Leaf@123"
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		
		driver.findElement(By.id("Login")).click();

//		3) Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		//4) Click confirm on Confirm redirect
		Set<String> allWh = driver.getWindowHandles();
		List<String> lstWh = new ArrayList<String>(allWh);
		driver.switchTo().window(lstWh.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
//		5) Click Learning 
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(30);
		shadow.findElementByXPath("//span[text()='Learning']").click();
		
//		6) Mouse hover on Learning On Trailhead	
		WebElement learnTHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions builder = new Actions(driver);
		builder.moveToElement(learnTHead).perform();
		
//		7) Clilck on Salesforce Certifications
	    builder.scrollToElement(learnTHead).perform();
		
		WebElement certificate = shadow.findElementByXPath("//h4/a[text()='Salesforce Certification']");
        driver.executeScript("arguments[0].click();", certificate);
        
//		7. Choose Your Role as Salesforce Architect 
        driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
        
//		8. Get the Text(Summary) of Salesforce Architect
        System.out.println("\nSUMMARY OF SALESFORCE ARCHITECT: ");
        System.out.println(driver.findElement(By.xpath("//div[contains(@class,'cert-site_text')]")).getText());
        
//		9. Get the List of Salesforce Architect Certifications Available 
        List<WebElement> al = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		System.out.println("\nSALESFORCE ARCHITECT CERTIFICATIONS: ");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i).getText());
		}
          
//		10. Click on Application Architect  
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
//		11.Get the List of Certifications available
		List<WebElement> al1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		System.out.println("\nAPPLICATION ARCHITECT CERTIFICATIONS: ");
		for(int i=0; i<al1.size(); i++) {
			System.out.println(al1.get(i).getText());
		}
		
//		12.Take a snapshot of Ceritificate
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshots/ApplicationArchitect.png");
		FileUtils.copyFile(src, dest);
		
//		13. Close
		//driver.close();
	}
}
