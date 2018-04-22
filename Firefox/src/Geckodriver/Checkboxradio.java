package Geckodriver;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
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

//Adding comment
class Checkboxradio {
	WebDriver driver;
	String baseUrl ="https://letskodeit.teachable.com/p/practice";
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}


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
	public void testListOfElements() throws Exception {
		boolean isChecked = false;
		List <WebElement> radioButtons = driver.findElements(By.xpath("//input[contains(@name,'cars')]"));
		int size = radioButtons.size();
		System.out.println("Size of the list: " + size);
		for (int i=0; i<size; i++) {
			isChecked = radioButtons.get(i).isSelected();
			
			if (!isChecked) {
				radioButtons.get(i).click();
				Thread.sleep(2000);
			}
		}
	}	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}

}
