package helpers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public static void takeScreenshot(File filename, WebDriver driver) {
		TakesScreenshot camera = (TakesScreenshot) driver;
		byte[] imageBytes = camera.getScreenshotAs(OutputType.BYTES);
		BufferedOutputStream bos;
		try {
			bos = new BufferedOutputStream(new FileOutputStream(filename));
			bos.write(imageBytes);
			bos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
