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
		
		// Displaying all iframe IDs
		int totalIframes=iframeElements.size();
		int currentIframeIndex=0;
		for (WebElement element:iframeElements){
			System.out.println(element.getAttribute("id")+" index="+currentIframeIndex++);
		}
		
		//Switching to IF2
		driver.switchTo().frame(iframeElements.get(1).getAttribute("id"));
		
		//Clicking to Tab2 on IF2 iframe
		driver.findElement(By.id("ui-id-2")).click();

		//Switching to IF1
		driver.switchTo().defaultContent();
		driver.switchTo().frame(iframeElements.get(0).getAttribute("id"));
		
		//Checking the QTP checbox
		driver.findElement(By.id("tool-0")).click();

		//Switching back to main iframe
		driver.switchTo().defaultContent();
	}
}
