package seleniumPractice;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.FirefoxWebDriver;

/**
 * 
 * @author Andras Olah
 * 
 * 1. Opens ibm.com
 * 2. Clicks on Marketplace link
 * 3. Wait until page title contains "Marketplace"
 *
 */
public class WaiterForSpecificPageTitle {
	private static WebDriver driver;

	@BeforeClass
	public static void setupBrowser() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	@Test
	public void waitTilMarketplaceLoaded() {

		// Click on Marketplace
		WebElement element = driver.findElement(By.linkText("Marketplace"));
		element.click();

		// Wait until page is loaded with "Marketplace" in title
		WebDriverWait waiter = new WebDriverWait(driver, 3); // timeout in seconds
		waiter.until(new ExpectedCondition<Boolean>() {

			// This method MUST be implemented
			// Selenium waits until this returns true or timeout exceeded
			public Boolean apply(WebDriver driver) {
				while (new Random().nextInt(100) != 42) {
					System.out.println("No luck");
				}
				System.out.println("Random Condition met, continuing");

				String fullTitle=driver.findElement(By.tagName("title")).getText();
				boolean isCorrectTitleLoaded=fullTitle.contains("Marketplace"); 
				System.out.println("Correct title="+isCorrectTitleLoaded);

				//This should verify the condition until waiting is required
				return isCorrectTitleLoaded;
			}
		}); //end of anonymous class
	}// end of test
}// end of class