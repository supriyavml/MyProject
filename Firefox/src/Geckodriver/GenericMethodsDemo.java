package Geckodriver;
import utilities.GenericMethods;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

class GenericMethodsDemo {
	private WebDriver driver;
	private String baseurl;
	private GenericMethods gm;
	
	@BeforeEach
	void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseurl = "https://letskodeit.teachable.com/pages/practice";
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

	}
	
	@Test
	void test() {
		driver.get(baseurl);
		
		WebElement element = gm.getElement("//input[@id='name']", "Xpath");
		element.sendKeys("testr");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	Thread.sleep(2000);
	driver.close();
	}

	

}
