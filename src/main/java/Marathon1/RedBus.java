package Marathon1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		//01) Launch Chrome
		ChromeDriver driver = new ChromeDriver();
		
		//02) Load https://www.redbus.in/
		driver.get("https://www.redbus.in/");
		
		driver.manage().window().maximize();
		
		//03) Type "Chennai" in the FROM text box
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai", Keys.ENTER);
		
		//04) Type "Bangalore" in the TO text box
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore", Keys.ENTER);
		
		//05) Select tomorrow's date in the Date field 
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr/td[text()='16']")).click();
		
		//06) Click Search Buses 
		Thread.sleep(1000);
		driver.findElement(By.id("search_btn")).click();
		
		//07) Print the number of buses shown as results (104 Buses found)
		//08) Choose SLEEPER in the left menu 
		//09) Print the name of the second resulting bus 
		//10) Click the VIEW SEATS of that bus
		//11) Print the Seats available(Example 20 Seats available)


	}
}
