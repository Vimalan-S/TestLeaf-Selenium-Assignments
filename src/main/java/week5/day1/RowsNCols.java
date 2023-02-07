package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RowsNCols {

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
		
		
//		2. Get the count of number of rows
		List<WebElement> rowsCnt = driver.findElements(By.xpath("(//table)[1]//tr"));
		System.out.println("ROWS COUNT FOR TABLE-1: " + rowsCnt.size());
		
		List<WebElement> rowsCnt2 = driver.findElements(By.xpath("(//table)[2]//tr"));
		System.out.println("ROWS COUNT FOR TABLE-2: " + rowsCnt2.size());
		
		
//		3. Get the count of number of columns
		List<WebElement> colsCnt = driver.findElements(By.xpath("(//table)[1]//tr//th"));
		System.out.println("\nCOLUMN COUNT FOR TABLE-1: " + colsCnt.size());
		
		List<WebElement> colsCnt2 = driver.findElements(By.xpath("(//table)[2]//tr//th"));
		System.out.println("COLUMN COUNT FOR TABLE-2: " + colsCnt2.size());

	}

}
