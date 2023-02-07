package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChittorgarhTable {

	public static void main(String[] args) {
		
		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL 
		driver.get("https://www.chittorgarh.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
//		2. Click on stock market 
		driver.findElement(By.xpath("//a[@title='Stock Market']")).click();
		
//		3. Click on NSE bulk Deals 
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
//		4. Get all the Security names //table[@class='table table-bordered table-striped table-hover w-auto']
		List<WebElement> rowsCnt = driver.findElements(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr"));
		List<String> securityNames = new ArrayList<String>();
		
		System.out.println("TOTAL NO. OF SECURITY NAMES: " + securityNames.size());
		System.out.println("\nSECURITY NAMES:");
		
		for(int i=1; i<rowsCnt.size(); i++) {
			System.out.println(driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr["+i+"]//td[1]")).getText());
			securityNames.add(driver.findElement(By.xpath("//table[@class='table table-bordered table-striped table-hover w-auto']//tr["+i+"]//td[1]")).getText());
		}
		
//		5. Ensure whether there are duplicate Security names
		Set<String> hset = new LinkedHashSet<String>(securityNames);
		System.out.println("\nFound "+ (securityNames.size()-hset.size()) + " no.of Duplicate Security Names");

	}
}
