package seleniumCommands;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import drivers.FirefoxWebDriver;

/*
 * http://www.ufthelp.com/2014/11/what-is-javascriptexecutor-in-selenium.html
 * 
 * 
 * JavascriptExecutor js = (JavascriptExecutor) driver;  
 * js.executeScript(Script,Arguments); 
 * 
 * script - The JavaScript to execute
 * Arguments - The arguments to the script.(Optional)
 * */
public class JavaScriptExecutor {

	static WebDriver driver;

	public static void pageSetup() {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
	}

	public static void main(String[] args) {
		pageSetup();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('hello world');");
	}
}
