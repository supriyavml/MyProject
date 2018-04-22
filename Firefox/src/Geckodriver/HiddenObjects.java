package Geckodriver;

import static org.junit.jupiter.api.Assertions.*;
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

class HiddenObjects {
	WebDriver driver;
	String baseurl1 ="https://letskodeit.teachable.com/p/practice";
	String baseurl2 = "https://www.expedia.com/";
	
	
	@BeforeEach
	void setUp() throws Exception {
			driver = new FirefoxDriver();
			baseurl1 = "http://letskodeit.teachable.com/pages/practice";
			
			// Maximize the browser's window
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

	}
	
	@Test
	void testLetsKodeit() throws InterruptedException {
		driver.get(baseurl1);
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Is Textbox Displayed"+ textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Hide button is clicked");
		System.out.println("Is text box displyed"+ textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Show button is clicked");
		System.out.println("Is text box displyed"+ textBox.isDisplayed());
		
	
	}

	@Test
	void testExpedia() throws InterruptedException {
		Thread.sleep(3000);
		driver.get(baseurl2);
		WebElement childAge = driver.findElement(By.id("package-1-age-select-1"));
		//package-1-age-select-1-hp-package
		System.out.println("Child Age Dropd own is displayed"+ childAge.isDisplayed());
		
	}
	@AfterEach
	void tearDown() throws Exception {
	}

	

}
