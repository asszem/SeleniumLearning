package seleniumCommands;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.FirefoxWebDriver;

public class FindByAnnotation {

	static WebDriver driver;

	public static void main(String[] args) {
		System.out.println("FindBy Annotation test started");
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");

		// PageFactory.initElements() must be used after page object instantiation to find elements marked with @FindBy annotation.
		IBMMainPage ibmMainPage = new IBMMainPage(driver);
//		ibmMainPage.marketPlaceButton.click();  //usind direct reference to webelement's click method
		ibmMainPage.clickAtMarketPlaceButton(); //using the method in class
	}
}

class IBMMainPage {
	// https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/support/FindBy.html
	// https://stackoverflow.com/documentation/selenium-webdriver/6777/using-findby-annotations-in-java#t=201710090845219559163
	// https://stackoverflow.com/questions/18436102/selenium-findby-vs-driver-findelement
	/*
	 * CLASS_NAME: @FindBy(className = "classname") CSS: @FindBy(css = "css") ID: @FindBy(id = "id") ID_OR_NAME: @FindBy(how = How.ID_OR_NAME, using ="idOrName") LINK_TEXT: @FindBy(linkText= "text")
	 * NAME: @FindBy(name= "name") PARTIAL_LINK_TEXT: @FindBy(partialLinkText= "text") TAG_NAME: @FindBy(tagName="tagname") XPATH: @FindBy(xpath="xpath")
	 */
	@FindBy(partialLinkText = "Marketplace")
	static WebElement marketPlaceButton;

	// Constructor to initilase page object with PageFactory
	public IBMMainPage(WebDriver driver) {
		// PageFactory.initElements() must be used after page object instantiation to find elements marked with @FindBy annotation.
		PageFactory.initElements(driver, this);
	}

	public void clickAtMarketPlaceButton(){
		marketPlaceButton.click();
	}
}
