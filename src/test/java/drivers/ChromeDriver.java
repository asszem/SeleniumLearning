package drivers;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriver {

	private static String OS = System.getProperty("os.name").toLowerCase();
	private ChromeOptions options = new ChromeOptions();

	public WebDriver initializeBrowser() {
		if (OS.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			options.addArguments("--kiosk");
		} else if (OS.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
			// options.addArguments("--start-fullscreen");
		}
			System.setProperty("webdriver.chrome.logfile", "src/test/resources/logs/chromedriverLog.txt");

		String downloadFilepath = "src/test/resources/files/download";
		// chromePrefs.put("download.default_directory", downloadFilepath);

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		// chromePrefs.put("profile.default_content_settings.popups", 0);
		// chromePrefs.put("download.prompt_for_download", "true");
		chromePrefs.put("safebrowsing.enabled", "true");

		// Sources that I have tried...
		// http://www.assertselenium.com/java/list-of-chrome-driver-command-line-arguments/
		// https://sites.google.com/a/chromium.org/chromedriver/capabilities
		// https://peter.sh/experiments/chromium-command-line-switches/
		// https://stackoverflow.com/questions/45817998/how-disable-this-type-of-file-can-harm-your-computer-do-you-want-to-keep-file

		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("safebrowsing-disable-download-protection");
		options.addArguments("safebrowsing-disable-extension-blacklist");
		options.addArguments("safebrowsing-manual-download-blacklist");
		options.addArguments("secondary-display-layout=l");

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cap);

		WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver(options);
		driver.manage().deleteAllCookies();
		return driver;
	}
}
