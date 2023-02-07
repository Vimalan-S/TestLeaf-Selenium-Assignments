package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class ServiceNow {

	public static void main(String[] args) throws IOException {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
		        
		WebDriverManager.chromedriver().setup();
	
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//01) Login to ServiceNow
		driver.get("https://dev62925.service-now.com/");
		
		driver.manage().window().maximize(); 

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("GAhMak34tH-^");
		
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
//		3. Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(10);
		shadow.findElementByXPath("//div[@aria-label='All']").click();
		
		WebElement sc = shadow.findElementByXPath("//span[text()='Service Catalog']");
		driver.executeScript("arguments[0].click()", sc);
		
//		4. Click on  mobiles 
		WebElement mob = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(mob);
		shadow.findElementByXPath("//a[text()='Mobiles']").click();
		
//		5. Select Apple iPhone 13 
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		
//		6. Click as No in Is this a replacement for a lost or broken iPhone? 
		driver.findElement(By.xpath("(//label[@class='radio-label'])[2]")).click();
		
//		7. Select Unlimited in  Monthly data allowance //select[contains(@class,'cat_item')]
		WebElement slct = driver.findElement(By.xpath("//select[contains(@class,'cat_item')]"));
		Select obj = new Select(slct);
		obj.selectByVisibleText("Unlimited");
		
//		8. Choose color field as Blue and storage field as 256 GB 
		driver.findElement(By.xpath("(//label[@class='radio-label'])[5]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[10]")).click();
		
//		9. Click  Order now Button 
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
//		10. Verify order is placed and get the request number" 
		if(driver.findElement(By.xpath("//span[@aria-live='assertive']")).getText().equals("Thank you, your request has been submitted")) System.out.println("Order is placed SUCCESSFULLY!");
		else System.err.println("Failed to place order");
		
		System.out.println("\nREQUEST NO: " + driver.findElement(By.xpath("(//b)[2]")).getText());
			
//		11. Take a Snapshot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshots/Order.png");
		FileUtils.copyFile(src, dest);
		
//		12. Close the browser
		//driver.close();
	}
}
