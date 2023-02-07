package week5.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {

		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

//				1) Go to https://www.myntra.com/
		driver.get("https://www.leafground.com/waits.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Wait for Visibility (1 - 10 Sec)
		driver.findElement(By.xpath("(//span[text()='Click'])[1]")).click(); 
		
		WebElement elmnt = driver.findElement(By.xpath("//span[text()='I am here']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(elmnt));
		
		System.out.println(elmnt.getText() + " is Displayed after 10s");
		
		
		// Wait for Invisibility (1 - 10 Sec)
		driver.findElement(By.xpath("(//span[text()='Click'])[2]")).click(); 
		
		WebElement elmnt1 = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.invisibilityOf(elmnt1));
		
		
		
		// Wait for Clickability
			// Click First Button
		WebElement clickFirst = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click First Button']")));
		clickFirst.click();
		
		WebElement clickSecond = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Click Second']")));
		clickSecond.click();
		
		
		
		// Wait for Text Change (1 - 10 Sec)
		driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click(); 
		
		WebElement elmnt2 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.textToBePresentInElement(elmnt2, "Did you notice?"));
		

	}

}
