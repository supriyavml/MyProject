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
import org.openqa.selenium.support.ui.Select;

class MultipleSelection {

	WebDriver driver;
	String baseUrl ="https://letskodeit.teachable.com/p/practice";
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}

	
	@Test
	void test() throws InterruptedException {
	driver.get(baseUrl);
	WebElement element = driver.findElement(By.id("multiple-select-example"));
	Select sel = new Select(element);
	
	Thread.sleep(2000);
	System.out.println("Selcet Orange by Value");	
	sel.selectByValue("orange");
	
	Thread.sleep(2000);
	System.out.println("Deselcet Orange by Value");	
	sel.deselectByValue("orange");
	
	Thread.sleep(2000);
	System.out.println("Selcet Peach by Index");	
	sel.selectByIndex(2);
	
	Thread.sleep(2000);
	System.out.println("Selcet Apple by Visible text");	
	sel.selectByVisibleText("Apple");
	
	Thread.sleep(2000);
	System.out.println("Print all Selceted Values");	
	List<WebElement> selectedoptions = sel.getAllSelectedOptions();
	for(WebElement option : selectedoptions)
	{
		System.out.println(option.getText());
	}
	
	Thread.sleep(2000);
	System.out.println("Deselect all Selceted Values");	
	sel.deselectAll();
	
	}
	
	@AfterEach
	void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.navigate().to("http:///google.com");
		driver.close();
	}


}
