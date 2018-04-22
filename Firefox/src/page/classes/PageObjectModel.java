package page.classes;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import page.classes.SearchPage;

public class PageObjectModel {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		SearchPage.fillOriginTextBox(driver, "New York");
		Thread.sleep(2000);

		SearchPage.fillDestinationTextBox(driver,"Chicago");
		Thread.sleep(2000);

		SearchPage.fillDepartureDateTextBox(driver,"30");
		Thread.sleep(2000);
		SearchPage.fillReturnDateTextBox(driver,"15");
		
		Thread.sleep(2000);
		SearchPage.clickOnSearchButton(driver);

		// Added a line to clear the return date text box
		// before entering the return date, because Expedia by default
		// enters the return date same as the departure date
		//SearchPage.returnDateTextBox(driver).clear();
	//	SearchPage.returnDateTextBox(driver).sendKeys("12/31/2014");
	//	SearchPage.clickOnSearchButton(driver);
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

}
