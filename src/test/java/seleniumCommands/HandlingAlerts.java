package seleniumCommands;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.FirefoxWebDriver;

public class HandlingAlerts {

	private static WebDriver driver;

	public static void setupBrowser() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
	}

	public static void main(String[] args) {
		setupBrowser();
		String xpath="//*[@id=\"content\"]/p[8]/button";
		//Invoke the alert
		driver.findElement(By.xpath(xpath)).click();
		try {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        System.out.println("Switched to alert");
	        alert.accept();
	        System.out.println("Alert accepted");
	    } catch (Exception e) {
	    }	
	}
}

/*If the alert is an authentication, the easiest way is to provid the following URL 
 * 
 * http://username:password@URL
 * */
