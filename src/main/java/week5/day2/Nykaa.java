package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

//		1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		

//		2) Mouseover on Brands and Search L'Oreal Paris
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		
//		3) Click L'Oreal Paris 
		driver.findElement(By.xpath("(//a[contains(text(),'Oreal Paris')])[1]")).click();
		
//		4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		String title = driver.getTitle();
		if(title.contains("Oreal Paris")) System.out.println("TITLE: " + title);
		else System.err.println("Invalid title");
		
//		5) Click sort By and select customer top rated  
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
//		6) Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		
		WebElement hairCare = driver.findElement(By.xpath("//span[text()='Hair Care']"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.visibilityOf(hairCare));
		hairCare.click();

		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
//		7) Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
//		8) check whether the Filter is applied with Shampoo 
		if(driver.findElement(By.xpath("(//span[@class='filter-value'])[2]")).getText().contains("Color Protection")) System.out.println("Color Protection filter successfully applied!");

//		9) Click on L'Oreal Paris Colour Protect Shampoo 
		driver.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@class='css-xrzmfa']")));
		
//		10) GO to the new window and select size as 175ml 
		Thread.sleep(7000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		
//		11) Print the MRP of the product 
		System.out.println("MRP: " + driver.findElement(By.xpath("(//span[contains(@class,'css')])[8]")).getText());
		
//		12) Click on ADD to BAG 
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
		
//		13) Go to Shopping Bag  
		driver.findElement(By.id("view_bag_snackbar")).click();
		
//		14) Print the Grand Total amount
		String grandTotal = driver.findElement(By.xpath("//div[contains(@class,'footer')]/div/div/div/span")).getText();
		System.out.println("Grand Total: " + grandTotal);	
		
//		15) Click Proceed 
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		
//		16) Click on Continue as Guest 
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
//		17) Check if this grand total is the same in step 14 
		if(grandTotal.contains(driver.findElement(By.xpath("(//p[contains(@class,'css')])[10]")).getText())) System.out.println("Grand Total = " + grandTotal + " has been verified successfully");
		
//		18) Close all windows
		driver.close();
	}
}
