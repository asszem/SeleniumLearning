package seleniumCommands;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.FirefoxWebDriver;

public class WaitForCondition {

	private static WebDriver driver;

	@BeforeClass
	public static void setupBrowser() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	//Some examples of ExpectedConditions usage
	@Ignore
	@Test
	public void waitUntilVisibiltiyOfElementLocated() {
		WebDriverWait waiter = new WebDriverWait(driver, 3); // timeout in seconds
		waiter.until(ExpectedConditions.visibilityOfElementLocated(By.className("mainContent")));
		waiter.until(ExpectedConditions.titleContains("Archives"));
	}

	/**
	 * Title must be exactly "IBM Marketplace - United Kingdom" before timeout
	 */
	@Test
	public void waitUntilTimeoutReached() {

		WebDriverWait waiter = new WebDriverWait(driver, 3); // timeout in seconds
		waiter.until(new ExpectedCondition<Boolean>() {

			// Selenium waits until this returns true or timeout exceeded
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.tagName("title")).getText().equals("IBM - United Kingdom");
			}
		}); // end of anonymous class
	}

	/***
	 * Title must contain "IBM" before timeout
	 */
	@Test
	public void waitUntilTimeoutReached2() {
		WebDriverWait waiter = new WebDriverWait(driver, 3); // timeout in seconds
		ExpectedCondition<Boolean> condition = ExpectedConditions.titleContains("IBM");
		waiter.until(condition);
	}


	/**
	 * Infinite loop - until Marketplace button is clicked by YOU.
	 */
	@Test
	public void waitForEternity() {
		ExpectedCondition<Boolean> condition = ExpectedConditions.titleContains("Marketplace");
		long startTime = System.nanoTime();
		long NANO_TO_SEC = 1000000000;
		while (!condition.apply(driver)) {
			long elapsedTime = System.nanoTime() - startTime;
			if (elapsedTime / NANO_TO_SEC > 10)
				break;
		}
		long stopTime = System.nanoTime();
		long totalTime = stopTime - startTime;
		System.out.printf("Nanosec:%d%nSecond:%d%n", totalTime, (totalTime / NANO_TO_SEC));
	}

}
