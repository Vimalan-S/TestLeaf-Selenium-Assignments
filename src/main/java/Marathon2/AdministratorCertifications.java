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

public class AdministratorCertifications {

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
		
//		4) Click confirm on Confirm redirect
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
		
//		8) Verify the title as Certification - Administrator Overview
		String title = driver.getTitle();
		if(title.equals("Certification - Administrator Overview")) System.out.println("Title successfully verified");
		else System.err.println("TItle verification failed");
		
//		9) Verify the Certifications available for Administrator Certifications should be displayed
		List<WebElement> al = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		
		System.out.println("\nAdministrator Certification Courses: ");
		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i).getText());
		}
		
//		10) Take a snapshot of Ceritificate
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshots/AdministratorCertificates.png");
		FileUtils.copyFile(src, dest);
		
//		11) Close Browser
		//driver.close();
	}
}
