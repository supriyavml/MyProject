package Geckodriver;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
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

class SwitchWindow {
	WebDriver driver;
	String baseUrl ="https://letskodeit.teachable.com/p/practice";


	@BeforeEach
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseUrl);

	}

	@Test
	public void test() throws InterruptedException {
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

	@After
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}


