package week4.day2.WindowHandling;

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

public class WindowHandling {

	public static void main(String[] args) {
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("https://www.leafground.com/window.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// 1) Click and Confirm new Window Opens 
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		Set<String> allWh = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(allWh);
		
		driver.switchTo().window(lst.get(1));
		
		// Verification
		if(driver.getTitle().equals("Dashboard")) System.out.println("TITLE: " + driver.getTitle() + " has successfully Opened on New Tab");
		
		System.out.println("Closed " + driver.getTitle());
		driver.close();
		driver.switchTo().window(lst.get(0));
		
		
		// 2) Find the number of opened tabs Open Multiple
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		Set<String> allWh1 = driver.getWindowHandles();
		System.out.println("\nTOTAL NO.OF TABS: " + (allWh1.size()));
		
		
		// 3) Close all windows except Primary
		String parent = driver.getWindowHandle();
		
		for(String eachWh : allWh1) {
			if(!eachWh.equals(parent)) {
				driver.switchTo().window(eachWh);
				System.out.println("Closed " + driver.getTitle());
				driver.close();
			}
		}		
	}
}
