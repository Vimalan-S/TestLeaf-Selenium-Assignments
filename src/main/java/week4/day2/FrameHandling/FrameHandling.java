package week4.day2.FrameHandling;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling {

	public static void main(String[] args) {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL 
		driver.get("https://www.leafground.com/frame.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
		// Click Me (Inside frame)
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println("AFTER CLICKING THE BUTTON INSIDE A FRAME: " + driver.findElement(By.xpath("//button[@id='Click']")).getText());
		
		driver.switchTo().defaultContent();
		
		
		
		// Click Me (Inside Nested frame)
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		System.out.println("AFTER CLICKING THE BUTTON INSIDE NESTED FRAME: " + driver.findElement(By.xpath("//button[@id='Click']")).getText());
		
		driver.switchTo().defaultContent();
		
		
		// How many frames in this page?
		List<WebElement> al = driver.findElements(By.tagName("iframe"));
		System.out.println("NO. OF IFRAMES: " + al.size());
	
	}
}
