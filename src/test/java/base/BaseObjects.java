package base;

import org.testng.annotations.AfterMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseObjects {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties loc = new Properties();
	public static FileReader confReader;
	public static FileReader locReader;
	public static String url;
	public static String browser;
	public static String signIn_link_field;
	public static String email_field;
	public static String next_btn_field;
	public static String password_field;
	public static String login_next_field;
	public static String skip_link_field;

	@BeforeMethod
	public void setup() throws IOException {

		if (driver == null) {
			System.out.println("The path is: " + System.getProperty("user.dir"));
			FileReader confReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\config.properties");
			FileReader locReader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configFiles\\locators.properties");

			config.load(confReader);
			loc.load(locReader);

			// Reading config properties
			browser = config.getProperty("browser");
			url = config.getProperty("testurl");

			// Reading login page properties
			signIn_link_field = loc.getProperty("signIn_link");
			email_field = loc.getProperty("email");
			next_btn_field = loc.getProperty("next_btn");
			password_field = loc.getProperty("password");
			login_next_field = loc.getProperty("login_next");
			skip_link_field = loc.getProperty("skip_link");
		}

		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(url + browser);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
			driver.manage().window().maximize();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(url + browser);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.get(url);
			driver.manage().window().maximize();
		}
	}

	@AfterMethod
	public void tearDown() {
		System.out.println("tear down");
		driver.quit();
	}
}
