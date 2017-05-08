package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class mainPage {
	private static WebElement element = null;
	
	public static WebElement dataLink (WebDriver driver){
		element = driver.findElement(By.partialLinkText("Data"));
		return element;
	}
	
	public static WebElement oldSiteLink (WebDriver driver){
		element = driver.findElement(By.partialLinkText("visit the old site here"));
		return element;
	}
	
	public static WebElement byCountry (WebDriver driver){
		element = driver.findElement(By.partialLinkText("By Country"));
		return element;
	}
	
	public static WebElement siteNameDiv (WebDriver driver){
		element = driver.findElement(By.cssSelector("div[class=\"site-name\"] a"));
		return element;
	}
	
	public static WebElement pageTitleSection (WebDriver driver){
		element = driver.findElement(By.className("page-title"));
		return element;
	}
	
	public static void clickHighIncome (WebDriver driver){
		if (driver instanceof JavascriptExecutor){
			((JavascriptExecutor) driver)
			.executeScript("document.querySelector(\"a[href='http://archive.data.worldbank.org/income-level/HIC']\").click();");
		}
	}
	
	public static void clickcountryLink (WebDriver driver,String country){
		System.out.println("document.querySelector(\"a[href*=\""+country+"\"]\").click();");
		if (driver instanceof JavascriptExecutor){
			((JavascriptExecutor) driver)
			.executeScript("document.querySelector(\"a[href*='"+country+"']\").click();");
		}
	}
	
	public static WebElement homeLink (WebDriver driver){
		element = driver.findElement(By.partialLinkText("Home"));
		return element;
	}
	
	
}