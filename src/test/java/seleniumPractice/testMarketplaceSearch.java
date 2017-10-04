package seleniumPractice;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import drivers.FirefoxWebDriver;

//Open IBM.com
//Click on Marketplace button
//Verify if Marketplace page loads
//Enter z14 in search field
//Submit
//Verify results
public class testMarketplaceSearch {

	private static WebDriver driver;

	@BeforeClass
	public static void setupBrowser() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	@Test
	public void testMarketplaceSearchForZ14() {
		System.out.println("Market Place Search started");
		// Locate the Marketplace button
		String marketPlaceButtonXpath = ".//*[@id='ibm-universal-nav']/nav/div[2]/p/a";
		WebElement marketPlaceButton = driver.findElement(By.xpath(marketPlaceButtonXpath));

		// Click it
		marketPlaceButton.click();

		// Verify if page loads
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// TODO wait until page fully loads before making the assertion
		try {
			int sleepTime = 50;
			System.out.println("Thread sleeps " + sleepTime);
			Thread.sleep(sleepTime);
			System.out.println("Thread wakes");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Page title=" + driver.getTitle());

		ExpectedCondition<Boolean> doesTitleContain = ExpectedConditions.titleContains("Marketplace");
		System.out.println("Does Title Contain Marketplace? = " + doesTitleContain.apply(driver));
		while (!doesTitleContain.apply(driver)) {
			System.out.println("Waiting...");
		}
		System.out.println("Does Title Contain Marketplace? = " + doesTitleContain.apply(driver));
		assertTrue(driver.getTitle().contains("Marketplace"));

		// Wait until search field is loaded
		String marketPlaceSearchFieldXpath = ".//*[@id='search-primary']/div/div[2]/form/div[2]/input";
		// driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		// Locate the search input field
		WebElement marketPlaceSearchField = driver.findElement(By.xpath(marketPlaceSearchFieldXpath));

		// Send a click to the search field before sending keys
		marketPlaceSearchField.click();
		System.out.println("Search field clicked");

		// Enter search term: "z14"
		marketPlaceSearchField.sendKeys("z14");
		System.out.println("z14 typed");

		// Wait for autocompleter results
		// driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		// String autocompleterClass = "react-autosuggest__suggestion--highlight";
		// WebElement autocompleter = driver.findElement(By.className(autocompleterClass));

		// Submit an Enter key
		marketPlaceSearchField.sendKeys(Keys.ENTER);
		System.out.println("Enter keystroke submitted");

		// Check result
		// Expected result: "[some number] result for z14"
		String foundXpath = ".//*[@id='ibm-content-main']/section/div/div[3]/div[1]/div[1]/div";
		final String regex = "\\d{1,} result for z14";
		final Pattern pattern = Pattern.compile(regex);
		ExpectedCondition<Boolean> isResult = ExpectedConditions.textMatches(By.xpath(foundXpath), pattern);
		System.out.println("Result is " + isResult.apply(driver));
	}

}
