package seleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import drivers.FirefoxWebDriver;
import static helpers.Pause.pause;

public class DragAndDrop {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");

		// Doesnt work
		// WebElement element = driver.findElement(By.className("ibm-btn-small ibm-btn-sec ibm-btn-blue-50"));

		// Works
		// WebElement element = driver.findElement(By.partialLinkText("Marketplace"));
		String xPathSource = ".//*[@id='ibm-pagetitle-h1']";
		WebElement element = driver.findElement(By.xpath(xPathSource));
		String xPathTarget = ".//*[@id='ibm-leadspace-body']/div[1]/div/div/h3[1]";
		WebElement targetElement = driver.findElement(By.xpath(xPathTarget));
		pause(3);
		Actions worker = new Actions(driver);
		worker.moveToElement(element);
		worker.clickAndHold();
		worker.moveByOffset(500, 300);
		// worker.moveToElement(targetElement);
		worker.release();
		// worker.click();
		worker.perform();

	}

}
