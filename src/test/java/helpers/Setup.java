package helpers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
	private static WebDriver driver = null;
	
	public static WebDriver setupBrowser(String browser){
		if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")){
			String chromePath = "src/test/resources/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
