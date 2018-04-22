package Geckodriver;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class Fleetcircit {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://fc.fleetcircuit.com/#/home";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	
	
}