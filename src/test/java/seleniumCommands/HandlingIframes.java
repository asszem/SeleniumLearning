package seleniumCommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.FirefoxWebDriver;

public class HandlingIframes {

	private static WebDriver driver;

	public static void setupBrowser() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
	}

	public static void main(String[] args) {
		setupBrowser();
		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
	}
}
