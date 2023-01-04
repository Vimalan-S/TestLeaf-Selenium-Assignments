package week2.day1.Assignment4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropdowns {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		
		// 1. Launch URL
		driver.get("https://www.leafground.com/select.xhtml");
		
		driver.manage().window().maximize();
		
		// 2. Selecting Selenium as fav UI Automation tool
		WebElement tool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select toolObj = new Select(tool);
		toolObj.selectByVisibleText("Selenium");
		
		Thread.sleep(1000);
		
		// 3. Selecting India as country 
		driver.findElement(By.xpath("//label[text()='Select Country']")).click(); 
		driver.findElement(By.xpath("//li[text()='India']")).click();
		
		Thread.sleep(1000);
		
		// 4. Selecting Chennai as state		
		driver.findElement(By.xpath("//label[text()='Select City']")).click(); 
		driver.findElement(By.xpath("//li[@data-label='Chennai']")).click();
		
		Thread.sleep(1000);
		
		// 5. Selecting the Course as Selenium Webdriver 
		driver.findElement(By.xpath("//button[@aria-label='Show Options']")).click();	
		Thread.sleep(1000);	
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		
		Thread.sleep(1000);
		
		// 6. Selecting the Language as Tamil	
		driver.findElement(By.xpath("//label[text()='Select Language']")).click(); 
		driver.findElement(By.xpath("//li[@data-label='Tamil']")).click();
		
		Thread.sleep(1000);
		
		// 7. Selecting 'Two' in Tamil font which is the first option in the dropdown
		driver.findElement(By.xpath("//label[text()='Select Values']")).click(); 
		driver.findElement(By.xpath("//li[@data-label='இரண்டு']")).click();
	}
}
