package Marathon3;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class ProjectSpecificMethod {
	public RemoteWebDriver driver;
	public String excelFile;
	
	@Parameters({"browser","url"})
	
	@BeforeMethod
	public void LaunchBrowser(String browser, String url) {
		
		// Disable Website notifications
		ChromeOptions optionC = new ChromeOptions();
		EdgeOptions optionE = new EdgeOptions();
		
        optionC.addArguments("--disable-notifications");
        optionE.addArguments("--disable-notifications");
        
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(optionC);
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver(optionE);
		}
			
		driver.manage().window().maximize();
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		
		driver.findElement(By.id("Login")).click();
		
		//. Click on toggle menu button from the left corner 
		driver.findElement(By.xpath("//button[contains(@class, 'salesforceIdentityAppLauncherHeader')]")).click();
		
		//. Click view All from App Launcher 
		driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="fetchData")
	public String[][] getData() throws IOException {
		String[][] readData = ReadExcel.readData(excelFile);
		
		return readData;
	}
}
