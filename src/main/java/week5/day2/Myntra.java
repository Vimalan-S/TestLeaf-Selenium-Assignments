package week5.day2;

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

public class Myntra {

	public static void main(String[] args) throws IOException, InterruptedException {

		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

//		1) Go to https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		2) Mouse hover on MeN 
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("(//a[text()='Men'])[1]"))).perform();
		
//		3) Click Jackets 
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		
//		4) Find the total count of item 
		System.out.println("Total count of Jackets for Men " + driver.findElement(By.xpath("//span[@class='title-count']")).getText());
		
//		5) Validate the sum of categories count matches
//		6) Check jackets 
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[1]")).click();
		
//		7) Click + More option under BRAND 
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
//		8) Type Duke and click checkbox 
		driver.findElement(By.xpath("//input[@placeholder='Search brand']")).sendKeys("Duke"); 
		driver.findElement(By.xpath("(//div[@class='common-checkboxIndicator'])[11]")).click();
				
//		9) Close the pop-up x 
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();
		
//		10) Confirm all the Coats are of brand Duke
//		    Hint : use List  
		Thread.sleep(5000);
		List<WebElement> duke = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		List<String> al = new ArrayList<String>();
		for(int i=1; i<duke.size(); i++) {
			al.add(duke.get(i).getText());
		}
		
		int flag = 0;
		for(String str: al) {		
			if(str.equals("Duke")) flag = 1;
			else flag = 0;
		}
		
		if(flag == 1) System.out.println("All Coats are from DUKE Brand");
		else if(flag == 0) System.out.println("All Coats are not from DUKE Brand");
//		
//		11) Sort by Better Discount 
		Actions builder1 = new Actions(driver); 
		builder1.moveToElement(driver.findElement(By.xpath("//div[@class='sort-sortBy']"))).perform();
		
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		
//		12) Find the price of first displayed item 
		System.out.println("Discounted Price: " + driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText());
		
//		Click on the first product
		driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).click();
		
		//Window Handling
		Set<String> allWh = driver.getWindowHandles();
		List<String> al1 = new ArrayList<String>(allWh);
		driver.switchTo().window(al1.get(1));
		
//		13) Take a screen shot
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshots/Duke.png");
		FileUtils.copyFile(src, dest);
		
//		14) Click on WishList Now 
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		
//		15) Close Browser
		//driver.close();
	}
}
