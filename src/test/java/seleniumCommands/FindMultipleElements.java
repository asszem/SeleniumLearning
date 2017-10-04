package seleniumCommands;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import drivers.FirefoxWebDriver;

/**
 * 
 * @author Andras Olah
 * 
 *         Find multiple elementS by various locator methods on IBM.com
 */
public class FindMultipleElements {
	static WebDriver driver;

	@BeforeClass // Runs only once, must be static
	public static void pageSetup() {
		System.out.println("Find Multiple elements on IBM.com started");
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	@AfterClass
	public static void closeFirefox() {
		// TODO find out why it results incorrect HTTP status
		// driver.quit();
	}

	public void listElements(List<WebElement> elements) {
		for (WebElement element : elements) {
			
			//TODO filter out empty results
			final String regex = "\\[^\\s]"; // any char that is not whitespace
			final Pattern pattern = Pattern.compile(regex); // creates the pattern
			Matcher m = pattern.matcher(element.getText()); // matches against element text
			boolean emptyElement =m.find();	//True if not whitespace found
			if (!emptyElement) {
				System.out.println(element.getText());
			}
		}
	}

	@Test
	public void by_IDs() {
		List<WebElement> elements = driver.findElements(By.id("ibm-home"));
		listElements(elements);
	}

	@Test
	public void by_TAG_ListItems() {
		List<WebElement> elements = driver.findElements(By.tagName("li"));
		System.out.println("Listing list items:");
		listElements(elements);
	}

	@Test
	public void by_ClassNames() {
		List<WebElement> elements = driver.findElements(By.className("ibm-masthead-categories"));
		System.out.println("Listing Class names:");
		listElements(elements);
	}

	@Test
	public void by_CSS_Selector(){
		// "div > p" all p elements inside of a div tag
		String cssSelector="div > p"; 
		List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
		System.out.println("List CSS element" +cssSelector);
		listElements(elements);

	}
	/*
	 * //@Ignore
	 * 
	 * @Test public void by_xPath() { String xPathExpression = ".//*[@id='ibm-home']/a"; WebElement element = driver.findElement(By.xpath(xPathExpression)); System.out.println("By xPath=" +
	 * element.getText()); }
	 * 
	 * @Test public void by_TAG() { try { int sleepTime = 5000; System.out.println("Thread sleeps " + sleepTime); Thread.sleep(sleepTime); } catch (InterruptedException e) { e.printStackTrace(); }
	 * System.out.println(driver.getTitle()); List<WebElement> allLinks = driver.findElements(By.tagName("a")); System.out.println("Links count is: " + allLinks.size()); for (WebElement link :
	 * allLinks) { // System.out.println(link.getText()); } }
	 * 
	 * @Test public void by_Name(){ WebElement element = driver.findElement(By.name("q")); }
	 * 
	 * @Test public void by_Title() { driver.getTitle().contains("IBM"); }
	 * 
	 * @Test(expected=NoSuchElementException.class) public void by_Missing_Element(){ WebElement element = driver.findElement(By.className("Should be missing"));
	 * System.out.println("Element by name \'Should be missing\' is actually missing");
	 * 
	 * }
	 */
}
