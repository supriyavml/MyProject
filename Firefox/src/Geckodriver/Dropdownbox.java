package Geckodriver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

class Dropdownbox {
	WebDriver driver;
	String baseUrl ="https://letskodeit.teachable.com/p/practice";


	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);

	}
	
	@Test
	/*void test() throws InterruptedException {
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by value");
		sel.selectByValue("benz");
		
		Thread.sleep(2000);
		System.out.println("Select Benz by Index");
		sel.selectByIndex(1);
		
		Thread.sleep(2000);
		System.out.println("Select Benz by Visible Text");
		sel.selectByVisibleText("BMW");
		
		Thread.sleep(2000);
		System.out.println("Print the list of options");
		List<WebElement> options = sel.getOptions();
		int size = options.size();
		
		for(int i=0; i<size; i++) {
			String optname = options.get(i).getText();
			System.out.println(optname);
		}
	}*/
	
	//Switch Windows examnple
	public void test1() throws InterruptedException {
		// Get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);
		
		// Find Open Window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// Get all handles
		Set<String> handles = driver.getWindowHandles();

		// Switching between handles
		for (String handle: handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("python");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		// Switch back to the parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
	}

	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
