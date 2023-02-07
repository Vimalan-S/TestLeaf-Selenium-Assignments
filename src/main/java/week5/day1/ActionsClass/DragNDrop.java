package week5.day1.ActionsClass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragNDrop {

	public static void main(String[] args) {

		// Disable Website notifications
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(option);
        
		WebDriverManager.chromedriver().setup();

		 //* 1. Launch URL 
		driver.get("https://www.leafground.com/drag.xhtml");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		// Draggable
		WebElement drgMeArnd = driver.findElement(By.xpath("//span[text()='Drag me around']"));
		System.out.println("INITIAL LOCATION: " + drgMeArnd.getLocation());
		
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drgMeArnd, 100, 0).perform();
		
		System.out.println("NEW LOCATION: " + drgMeArnd.getLocation());
		
		
		// Droppable
		WebElement drag = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		
		System.out.println("\nCOLOR BEFORE DROP: " + drop.getCssValue("background"));
		
		Actions builder1 = new Actions(driver);
		builder1.dragAndDrop(drag, drop).perform();
		
		System.out.println("COLOR AFTER DROP: " + drop.getCssValue("background"));
		
		
		// Draggable Columns
		// Swapping Category and Name
		WebElement category = driver.findElement(By.xpath("(//table)[5]//tr//th[2]"));
		WebElement name = driver.findElement(By.xpath("(//table)[5]//tr//th[1]"));
		
		System.out.println("\nCATEGORY LOCATION BEFORE SWAPPING: " + driver.findElement(By.xpath("(//table)[5]//tr//th[2]")).getLocation());
		
		Actions builder2 = new Actions(driver);
		builder2.dragAndDrop(category, name).perform();
		
		System.out.println("CATEGORY LOCATION AFTER SWAPPING: " + driver.findElement(By.xpath("(//table)[5]//tr//th[1]")).getLocation());
		
		
		// Draggable Rows
		// Swapping 8th row and 3rd row
		WebElement row8 = driver.findElement(By.xpath("(//table)[6]//tr[8]//td[1]"));
		WebElement row3 = driver.findElement(By.xpath("(//table)[6]//tr[3]//td[1]"));
		
		Actions builder3 = new Actions(driver);
		builder3.dragAndDrop(row8, row3).perform(); 
		
		System.out.println("CONFIRMATION MESSAGE: " + driver.findElement(By.xpath("//div[@class='ui-growl-message']")).getText());
		
	}
}
