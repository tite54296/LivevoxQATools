package helpers;
 
import org.junit.runner.RunWith;
import org.junit.*;
import org.openqa.selenium.*;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import stepDefinitions.WorldBankDataSteps;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features"},
		glue = {"src/test/java/stepDefinitions"}
		)

public class TestRunner {
	@AfterClass
	public static void tearDown(){
		WebDriver driver = WorldBankDataSteps.driver;
		driver.quit();
	}

}
