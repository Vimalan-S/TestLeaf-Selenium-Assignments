package week3.day1.Assignment1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// Step 6: Click on Create New Account button
		driver.findElement(By.linkText("Create New Account")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.name("firstname")).sendKeys("Vimalan");
			
		// Step 8: Enter the last name
		driver.findElement(By.name("lastname")).sendKeys("S");
		
		// Step 9: Enter the mobile number 
		driver.findElement(By.name("reg_email__")).sendKeys("1846284632");
			
		// Step 10: Enter the password 
		driver.findElement(By.name("reg_passwd__")).sendKeys("TestLeaf");
		
		// Step 11: Handle all the three drop downs
		// 11.1 Date
		WebElement date = driver.findElement(By.xpath("//select[@id='day']"));
		Select dateObj = new Select(date);
		dateObj.selectByIndex(24); // for 25th day
		
		// 11.2 Month
		WebElement mnth = driver.findElement(By.xpath("//select[@id='month']"));
		Select mnthObj = new Select(mnth);
		mnthObj.selectByIndex(9);
		
		// 11.3 Year
		WebElement yr = driver.findElement(By.xpath("//select[@id='year']"));
		Select yrObj = new Select(yr);
		yrObj.selectByVisibleText("2002");
		
		// Step 12: Select the radio button "Female"( A normal click will do for this step) 
		driver.findElement(By.xpath("//input[@name='sex' and @value='2']")).click();

	}
}
