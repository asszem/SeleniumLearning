package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import drivers.FirefoxWebDriver;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");
//		WebElement element = driver.findElement(By.className("ibm-btn-small ibm-btn-sec ibm-btn-blue-50"));
//		WebElement element = driver.findElement(By.partialLinkText("Marketplace"));
		WebElement element = driver.findElement(By.xpath(".//*[@id='ibm-universal-nav']/nav/div[2]/p/a"));

		
		Actions worker = new Actions(driver);
		worker.moveToElement(element);
//		worker.clickAndHold();
		worker.click();
		worker.perform();
		
		

	}

}
