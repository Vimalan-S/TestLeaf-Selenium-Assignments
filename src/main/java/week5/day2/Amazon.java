package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

//		1) Go to https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
//		2.search as oneplus 9 pro ");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Oneplus 9 pro");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		
//		3.Get the price of the second product 
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[2]")).getText();
		System.out.println("Rs." + price);
		
//		4. Print the number of customer ratings for the second displayed product 
		System.out.println("No. of Customer Ratings: " + driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText());
		
//		5. Mouse Hover on the stars 
		WebElement stars = driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star')])[1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(stars);
		stars.click();
		
		
//		6. Get the percentage of ratings for the 5 star.
		System.out.println("RATINGS: " + driver.findElement(By.xpath("(//span[@data-hook='acr-average-stars-rating-text'])[1]")).getText());
		
//		7. Click the first text link of the first image 
		driver.findElement(By.xpath("(//span[contains(@class,'a-size-medium a-color-base a-text-normal')])[2]")).click();
		
		// Handling new window
		Set<String> allWh = driver.getWindowHandles();
		List<String> al = new ArrayList<String>(allWh);
		driver.switchTo().window(al.get(1));
		
//		8. Take a screen shot of the product displayed
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snapshots/OnePlus9 Pro.png");
		FileUtils.copyFile(src, dest);
		
//		9. Click 'Add to Cart' button 
		driver.findElement(By.id("add-to-cart-button")).click();
		
//		10. Get the cart subtotal and verify if it is correct. 
		String subtotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		
		if(price.equals(subtotal)) System.out.println("Oneplus9 Pro: Rs." + subtotal + " has been added to Cart successfully!");
	}
}
