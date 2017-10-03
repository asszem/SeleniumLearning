package seleniumPractice;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Andras Olah (olahandras78@gmail.com)
 */
public class FindElementByMethodsOnIndexHu {

	public static void displayStuff(String... strings) {
		for (String string : strings) {
			System.out.println(string);
		}
	}

	public static void displayHeader(String header) {
		System.out.println("*************************" + header);
	}

	public static void displayElementInfo(WebElement inputElement, String inputAttribute){
		System.out.println("TagName =\t"+inputElement.getTagName());
		System.out.println("Attribute ("+inputAttribute+") = " + inputElement.getAttribute(inputAttribute));
		System.out.println("WebElement =");
		System.out.println(inputElement);
		System.out.println("");
	}
	public static void main(String[] args) {
		//<editor-fold desc="Setup WebDriver">
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriverX64.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", false); //true gives that Javascript error (AddonManager is not initialized)
		WebDriver driver = new FirefoxDriver();
		//</editor-fold>

		driver.get("http://index.hu");	//Opens Index.hu in a Firefox browser page
		WebElement element;  			//Define the element that will be used
		System.out.println("Page title is: " + driver.getTitle());

		//<section class="blokk divany-doboz container divany-header cimlap-blokk-index_divany" id="index_divany">
//		element = driver.findElement(By.id("index_divany"));
//		displayHeader("Find Element By Id");
//		displayElementInfo(element, "id");
//		displayElementInfo(element, "class");

		//<section class="blokk divany-doboz container divany-header cimlap-blokk-index_divany" id="index_divany">
		displayHeader("Find Element by ClassName");
		element = driver.findElement(By.className("header-hasab-1"));
		displayElementInfo(element, "class");

		displayHeader("Find element by DOM TagName");
		element = driver.findElement(By.tagName("A"));
		displayElementInfo(element, "A");
		
		//<meta name="apple-mobile-web-app-title" content="Index">
		displayHeader("Find element by Name");
		element=driver.findElement(By.name("apple-mobile-web-app-title"));
		displayElementInfo(element, "class");
		
		
		//<a href="http://divany.hu/" class="tovabb-a-cimlapra">Tovább a címlapra </a>
		displayHeader("Find element by Link Text");
		element=driver.findElement(By.linkText("Tovább a címlapra"));
		displayElementInfo(element, "class");
		
		
		//<a href="http://divany.hu/" class="tovabb-a-cimlapra">Tovább a címlapra </a>
		displayHeader("Find element by Partial Link Text");
		element = driver.findElement(By.partialLinkText("címlap"));
		displayElementInfo(element, "class");
		
		
		//<div id="food"><span class="dairy">milk</span><span class="dairy aged">cheese</span></div>
		//WebElement cheese = driver.findElement(By.cssSelector("#food span.dairy.aged"));
		//.divany-header
		displayHeader("Find element by CSS Selector");
		element=driver.findElement(By.cssSelector(".divany-header"));
		displayElementInfo(element, "class");
		
		
		//xpath to Divány: html/body/section[7]/div/div[1]/h3/a[1]
		List<WebElement> inputs = driver.findElements(By.xpath("//input"));
		displayHeader("Find element by XPath");
		element=driver.findElement(By.xpath("html/body/section[7]/div/div[1]/h3/a[1]"));
		displayElementInfo(element, "class");

//		driver.quit(); //Quits Firefox
	}
}
