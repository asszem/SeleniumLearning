package helpers;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;

import drivers.FirefoxWebDriver;

public class WriteFullSourcePageToFile {

	private static WebDriver driver;

	public static void main(String[] args) {
		driver = new FirefoxWebDriver().initializeFirefoxWebDriver();
		driver.get("https://ibm.com");

		String source = driver.getPageSource();

		try {
			String path = "C:/Users/IBM_ADMIN/Desktop/pagesource.txt";
			BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(path), CREATE, APPEND);
			bufferedWriter.write(source);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
