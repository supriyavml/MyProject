package Geckodriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class letskodeit {

		public static void main(String[] args) throws InterruptedException {
		
		String 	baseUrl = "http://letskodeit.teachable.com";
		WebDriver driver;
		
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\Download\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		
		//driver.findElement(By.className("gb_P")).click();
		
		driver.findElement(By.xpath("//div[@id='navbar']//a [contains (text(), 'Practice')]")).click();
		System.out.println(driver.findElement(By.xpath("//table[@id='product']//td[starts-with(text(),'Python')]//following-sibling::td")).getText());
		

		Thread.sleep(2000);
		//driver.close();
}
}