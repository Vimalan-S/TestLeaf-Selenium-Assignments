package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		//01) Launch Chome
		ChromeDriver driver = new ChromeDriver();		
		
		//02) Load https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//03) Type "Bags" in the Search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);
		
		//04) Choose the third displayed item in the result (bags for boys)
		System.out.println(driver.findElement(By.xpath("(//div[@class = 'a-row a-size-base a-color-secondary']/h5/span)[3]")).getText());
		
		//05) Print the total number of results (like 30000) 1-48 of over 30,000 results for "bags for boys"
		System.out.println(driver.findElement(By.xpath("(//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span)[1]")).getText());
		
		//06) Select the first 2 brands in the left menu (like American Tourister, Generic) driver.executeScript("arguments[0].click();",prime);
		
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']/label/i)[3]")).click();
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']/label/i)[2]")).click();
		
		//07) Confirm the results have got reduced (use step 05 for compare)
		System.out.println("\nAfter Selecting first 2 brands...");
		System.out.println(driver.findElement(By.xpath("(//div[@class = 'a-section a-spacing-small a-spacing-top-small']/span)[1]")).getText());
		
		//08) Choose New Arrivals (Sort)  
		driver.findElement(By.xpath("//span[@class = 'a-button a-button-dropdown a-button-small']")).click();
		driver.findElement(By.xpath("//a[text()= \"Newest Arrivals\"]")).click();
		
		//09) Print the Second resulting bag info (name) 
		System.out.println("\nProduct:\n"+driver.findElement(By.xpath("(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a/span)[2]")).getText());
			
		//10) Print the first resulting bag info (discounted price)
		System.out.println(driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText());
	}
}
