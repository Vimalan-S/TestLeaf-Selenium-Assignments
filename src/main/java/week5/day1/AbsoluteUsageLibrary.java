package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbsoluteUsageLibrary {

	public static void main(String[] args) {
		
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL 
		driver.get("https://html.com/tags/table/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		// You have to print the respective values based on given Library
		// (hint: if the library was absolute usage, then print all its value)
		System.out.println("FOR " + driver.findElement(By.xpath("(//table)[1]//tr[2]//td[1]")).getText() + " LIBRARY: ");
		
		System.out.println(driver.findElement(By.xpath("(//table)[1]//tr//th[2]")).getText() + " = " + driver.findElement(By.xpath("(//table)[1]//tr[2]//td[2]")).getText());
		System.out.println(driver.findElement(By.xpath("(//table)[1]//tr//th[3]")).getText() + " = " + driver.findElement(By.xpath("(//table)[1]//tr[2]//td[3]")).getText());
		System.out.println(driver.findElement(By.xpath("(//table)[1]//tr//th[4]")).getText() + " = " + driver.findElement(By.xpath("(//table)[1]//tr[2]//td[4]")).getText());
		

	}

}
