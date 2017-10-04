package seleniumCommands;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.FirefoxWebDriver;

public class FindElementsMethodsOnIBM {
	static WebDriver driver;

	@BeforeClass //Runs only once, must be static
	public static void pageSetup() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	@AfterClass
	public static void closeFirefox() {
		driver.quit();
	}

	@Test
	public void by_ID() {
		WebElement element = driver.findElement(By.id("ibm-home"));
		System.out.println("Element object" + element);
		System.out.println("\nBy Id=" + element.getText());
		System.out.println("By Id, get \"class\" attribute=" + element.getAttribute("class"));
	}

	@Ignore
	@Test
	public void by_Class() {
		WebElement element = driver.findElement(By.className("ibm-animate"));
		System.out.println("By ClassName=" + element.getText());
	}

	@Ignore
	@Test
	public void by_xPath() {
		String xPathExpression = ".//*[@id='ibm-home']/a";
		WebElement element = driver.findElement(By.xpath(xPathExpression));
		System.out.println("By xPath=" + element.getText());
	}

	@Test
	public void by_TAG() {
		try {
			int sleepTime = 5000;
			System.out.println("Thread sleeps " + sleepTime);
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Links count is: " + allLinks.size());
		for (WebElement link : allLinks) {
			// System.out.println(link.getText());
		}

	}
}
