package week4.day2.AlertHandling;

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

public class AlertHandling {

	public static void main(String[] args) {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("https://www.leafground.com/alert.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Handling Alert (Simple Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[1]")).click();
		Alert simpleAlert = driver.switchTo().alert();
		simpleAlert.accept(); 
		System.out.println("Successfully displayed: " + driver.findElement(By.xpath("//span[@id='simple_result']")).getText());
		
		
		//Alert (Confirm Dialog) 
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.accept(); 
		System.out.println("Successfully displayed: " + driver.findElement(By.xpath("//span[@id='result']")).getText());
		
		
		// Handling Sweet Alert (Simple Dialog)
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click(); 
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		System.out.println("Successfully handled Sweet Alert");
		
		
		// Handling Sweet Modal Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click(); 
		WebElement close = driver.findElement(By.xpath("(//span[contains(@class,'closethick')])[2]"));
		driver.executeScript("arguments[0].click()", close);
		System.out.println("Successfully handled Sweet Modal Dialog");
		
		
		// Handling Prompt Dialog
		driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Vimalan");
		promptAlert.accept(); 
		
		
		// Handling Sweet Alert (Confirmation)
		driver.findElement(By.xpath("//span[text()='Delete']")).click(); 
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		System.out.println("Successfully handled Sweet Alert (Confirmation)");	
		
		
		// Handling Minimize/maximize screen alert
		WebElement show = driver.findElement(By.xpath("(//span[text()='Show'])[6]")); 
		driver.executeScript("arguments[0].click()", show);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		System.out.println("Successfully Minimized the Alert");
	
		driver.findElement(By.xpath("(//span[contains(@class,'closethick')])[3]")).click();
		System.out.println("Successfully Closed the Minimized Alert");
	}
}
