package Geckodriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testgecko {

	public static void main(String[] args) {
	
	String 	baseUrl = "http://google.com";
	WebDriver driver;
	
	System.setProperty("webdriver.gecko.driver","C:\\Selenium\\Download\\geckodriver.exe");
	driver = new FirefoxDriver();
	
	driver.get(baseUrl);
	driver.findElement(By.className("gb_P")).click();

		
		
	}
	
	}