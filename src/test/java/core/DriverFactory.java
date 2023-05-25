package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
private static WebDriver driver;
	

	public static WebDriver getDriver() {

		if (driver == null) {
			createDriver();
		}
		return driver;
	}

	public static void createDriver() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dennis Andrade\\Documents\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void killDriver() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
