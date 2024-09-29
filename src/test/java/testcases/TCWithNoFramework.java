
package testcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class TCWithNoFramework {

	private static Logger ResLogger = LogManager.getLogger(TCWithNoFramework.class.getName());
	
		public static void main(String[] args) {
		
		ResLogger.info("before login - INFO Log");
		ResLogger.error("before login - ERROR Log");
		WebDriverManager.chromedriver().setup(); // base
		WebDriver driver = new ChromeDriver(); // base

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.zoho.com/"); // properties file -url

		driver.findElement(By.linkText("Sign In")).click(); // locators - properties file -
		
		//replace with correct email
		driver.findElement(By.id("login_id")).sendKeys("test@gmail.com");
		driver.findElement(By.id("nextbtn")).click();

		//replace with correct password
		driver.findElement(By.id("password")).sendKeys("123");
		driver.findElement(By.id("nextbtn")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(text(),'Skip for now')]")).click();

		System.out.println("logged in");
		ResLogger.info("after login - INFO Log -logged in");
		ResLogger.fatal("after login - FATAL  Log");

		driver.quit();
	}

}
