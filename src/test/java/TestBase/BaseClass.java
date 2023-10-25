package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

public static WebDriver driver;

	
	@BeforeSuite
	public void setup() throws InterruptedException {
		
		//System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--no-sandbox");

		options.addArguments("--disable-dev-shm-usage");

		//options.addArguments("--headless");

		options.addArguments("window-size=1400,900");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void tearDown() {
//		driver.quit();
	}

	
}
