package stepDefinitions;

import java.util.List;

import helpers.Setup;
import org.openqa.selenium.*;
import cucumber.api.java.en.*;
import org.testng.Assert;

public class WorldBankDataSteps {
	
	public static WebDriver driver = Setup.setupBrowser("edge");
	
	@When("^I access (.*) site$")
	public void accessSite(String site) throws Throwable {
		String url = "";
		if (site.equalsIgnoreCase("world bank")){
			url = "http://www.google.com";
		}else if (site.equalsIgnoreCase("High incomes")){
			url = "http://archive.data.worldbank.org/income-level/HIC";
		}
		driver.get(url);
		
	}
	
	@When("^I click on (.*) on .*$")
	public void openDataTab(String element) throws Throwable {
		if (element.equalsIgnoreCase("data")){
			pageObjects.mainPage.dataLink(driver).click();
		}else if (element.equalsIgnoreCase("old site")){
			pageObjects.mainPage.oldSiteLink(driver).click();
		}else if (element.equalsIgnoreCase("by country")){
			pageObjects.mainPage.byCountry(driver).click();
		}else if(element.equalsIgnoreCase("high incomes")){
			pageObjects.mainPage.clickHighIncome(driver);
		}else if(element.equalsIgnoreCase("home")){
			pageObjects.mainPage.homeLink(driver).click();
		}else {
			element = element.toLowerCase().replaceAll("[\\s\\W]", "-");
			pageObjects.mainPage.clickcountryLink(driver, element.toLowerCase());
		}
		
	}

	@Then("^the (.*) should open$")
	public void verifyPageOpen(String pageName) throws Throwable {
		String expectedTitle = "";
		if (pageName.equalsIgnoreCase("World bank home page")){
			expectedTitle = "World Bank Group";
		} else if (pageName.equalsIgnoreCase("World bank data page")){
			expectedTitle = "Data | The World Bank";
		} else if (pageName.equalsIgnoreCase("High incomes page")){
			expectedTitle = "High income | Data";
		} else if (pageName.matches("\\w* page")){
			String country = pageName.substring(0,pageName.length()-4);
			expectedTitle = country + " | Data";
		}
		Assert.assertEquals(driver.getTitle(),expectedTitle);
	}
	
	@Then("^I should be taken to (.*)$")
	public void verifyPageURL(String pageName) throws Throwable {
		String expectedURL = "";
		if (pageName.equalsIgnoreCase("old site")){
			expectedURL = "http://archive.data.worldbank.org/";
		}
		Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
	}
	
	@Then("^the (.*) name should be (.*)$")
	public void verifyName(String element,String name) throws Throwable {
		System.out.println(element);
		String actualValue = "";
		if (element.equalsIgnoreCase("tab")){
			actualValue = pageObjects.mainPage.siteNameDiv(driver).getText();
		}else if(element.equalsIgnoreCase("section")){
			actualValue = pageObjects.mainPage.pageTitleSection(driver).getText();
		}
		Assert.assertEquals(actualValue,name);
	}
	
	@Then("^(.*) should be present$")
	public void verifyTextPresent (String text){
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),\""+text+"\")]"));
		Assert.assertTrue(list.size() > 0, "Text not found!");
	}

}
