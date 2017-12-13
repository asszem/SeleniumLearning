package drivers;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

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
			System.setProperty("webdriver.gecko.driver", "C:\\webdrivers\\geckodriverX64.exe");
		}


		
		// Set download location
		FirefoxProfile profile = new FirefoxProfile();
		Path downloadLocationPath = Paths.get("files/download/");

		// 0 = desktop, 1 = default download folder , 2 = user defined location.
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", downloadLocationPath.toAbsolutePath().toString());
		
		
		// Disable save dialog window
		// https://stackoverflow.com/questions/36309314/set-firefox-profile-to-download-files-automatically-using-selenium-and-java
		// Set mime-type of .CFG file to octet-stream
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream; charset=UTF-8");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		
		// Set the log location
		System.setProperty("webdriver.firefox.logfile", "logs/firefoxdriverLog.txt");
		
		
		//Since Selenium 3.6 this is the preferred way to set firefox profile
		//https://stackoverflow.com/questions/46538090/java-selenium-3-6-0-cannot-set-profile
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false); // true gives that Javascript error (AddonManager is not initialized)
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
	
		FirefoxOptions options=new FirefoxOptions();
		options.merge(capabilities); //As addCapabilities is deprecated
		
		//TODO: Find out why this is not working...
		WebDriver driver = new org.openqa.selenium.firefox.FirefoxDriver(options);

		//TODO find out why this does not work and how to open window on secondary monitor
		// driver.manage().window().setSize(new Dimension(100, 100));
		// driver.manage().window().setPosition(new Point(10, 10));

		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}
}
