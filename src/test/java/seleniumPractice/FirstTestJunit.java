package seleniumPractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTestJunit {

	@Test	//Junit annotation
	public void firstTest(){
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriverX64.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://google.com");
		
		WebElement element = driver.findElement(By.id("lst-ib"));
		element.sendKeys("This is a test how SeleniumWebDriver works");
		
		element=driver.findElement(By.name("btnK"));
		element.click();
		
		System.out.println("Test completed");

	}

}

