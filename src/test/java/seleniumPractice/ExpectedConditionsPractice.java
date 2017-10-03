package seleniumPractice;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.FirefoxWebDriver;

/**
 *
 * @author Andras Olah (olahandras78@gmail.com)
 */
public class ExpectedConditionsPractice {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.navigate().to("http://ibm.com");
		String marketplaceClass = "ibm-btn-small ibm-btn-sec ibm-btn-blue-50";

		// Create Explicit and Implicit Waits
		String marketplaceXPath = ".//*[@id='ibm-universal-nav']/nav/div[2]/p/a";
		WebElement marketPlaceElement = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath(marketplaceXPath)));
		System.out.println("Marketplace element getText()="+ marketPlaceElement.getText());


		// Create Expected Conditions
		System.out.println("Expected conditions");
		System.out.println(ExpectedConditions.alertIsPresent());
		System.out.println(ExpectedConditions.titleContains("IBM"));

		// Expected conditions with apply to driver. The generic type must be correspondent to the method
		ExpectedCondition<Boolean> doesTitleContain = ExpectedConditions.titleContains("IBM");
		ExpectedCondition<Alert> isAlertPresent = ExpectedConditions.alertIsPresent();
		ExpectedCondition<WebElement> isMarketPlacePresent = ExpectedConditions
				.presenceOfElementLocated(By.xpath(marketplaceXPath));
		System.out.println("Does Title Contain IBM? = " + doesTitleContain.apply(driver));
		System.out.println("Is Alert present? = " + isAlertPresent.apply(driver));
		System.out.println("Is  present? = " + isMarketPlacePresent.apply(driver));

		// Setting multiple expections
		ExpectedCondition multipleConditions = ExpectedConditions.and(doesTitleContain, isMarketPlacePresent,
				ExpectedConditions.not(isAlertPresent));
		System.out.println("MultipleConditions without apply = " + multipleConditions);
		System.out.println("MultipleConditions with apply to driver = " + multipleConditions.apply(driver));


		driver.get("http://www.google.com");

		// driver.navigate().to("http://www.google.com");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form. WebDriver will find the form for us from the element
		element.submit();

		// Wait for 10 seconds. Creates an anonymus inner class and overrides the apply() method of exp.cond.
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

//		driver.quit();
	}
}
