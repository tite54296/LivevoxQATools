package helpers;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Setup {
	private static WebDriver driver = null;
	
	public static WebDriver setupBrowser(String browser){
		if (browser.equalsIgnoreCase("firefox")){
			String geckoPath = "src/test/resources/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoPath);
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")){
			String chromePath = "src/test/resources/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			String edgePath = "src/test/resources/drivers/MicrosoftWebDriver.exe";
			System.setProperty("webdriver.edge.driver", edgePath);
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
