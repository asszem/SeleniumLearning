package seleniumCommands;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import drivers.FirefoxWebDriver;

public class FindAllElements {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");

		// Find all "select" tag elements
		List<WebElement> elements = driver.findElements(By.tagName("select"));
		System.out.println("Displaying all select elements");
		for (WebElement element : elements) {
			Select select = new Select(element);
			System.out.printf("Text=%s, multiple=%b%n",element.getText()
					, select.isMultiple());
		}
		
		// Find all "option" tag elements
		List<WebElement> options = driver.findElements(By.tagName("option"));
		for (WebElement option:options){
			System.out.printf("Option value=%s%n", option.getAttribute("value"));
			System.out.printf("Option data-localecode=%s%n", option.getAttribute("data-localecode"));
			System.out.println();
		}
	}
}
