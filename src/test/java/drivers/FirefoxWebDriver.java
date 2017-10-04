package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Andras Olah (olahandras78@gmail.com)
 */
public class FirefoxWebDriver {

	private static String OS = System.getProperty("os.name").toLowerCase();

	// Method to actually initialize the driver once the FirefoxWebDriver object is created
	public WebDriver initializeFirefoxWebDriver() {

		if (OS.contains("mac")) {
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/firefox/osx/geckodriver");
		} else if (OS.contains("windows")) {
			System.out.println("Windows GeckoDriverX64 started");
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriverX64.exe");
		}

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false); // true gives that Javascript error (AddonManager is not initialized)

		WebDriver driver = new FirefoxDriver();
		//TODO find out why this does not work and how to open window on secondary monitor
		// driver.manage().window().setSize(new Dimension(100, 100));
		// driver.manage().window().setPosition(new Point(10, 10));

		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
