package Geckodriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class fleetcurcuitclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			WebDriver driver;
			String baseUrl;

		

				driver = new FirefoxDriver();
				baseUrl = "https://fc.fleetcircuit.com/#/home";
				
				// Maximize the browser's window
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(baseUrl);
				Thread.sleep(2000);

				
				
				WebElement login = driver.findElement(By.id("username"));
				login.sendKeys("ravi123");
				
				Thread.sleep(2000);
				
				WebElement pwd = driver.findElement(By.id("password"));
				pwd.sendKeys("Ravi123");
				Thread.sleep(2000);

				
				driver.findElement(By.xpath("//div//button[text() = 'Login']")).click();
				Thread.sleep(2000);

			}
			
				
	}


