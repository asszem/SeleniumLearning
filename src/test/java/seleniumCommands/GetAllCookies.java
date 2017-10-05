package seleniumCommands;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import drivers.FirefoxWebDriver;

public class GetAllCookies {

	static WebDriver driver;

	public static void pageSetup() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	public static void main(String[] args) {
		System.out.println("Finding all cookies");
		pageSetup();
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie currentCookie:cookies){
			System.out.printf("Name=%s, value=%s%n%n", currentCookie.getName(), currentCookie.getValue());
		}
	}

}
