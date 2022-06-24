package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	private static WebDriver driver;
	

	public DriverFactory() {

		if (driver == null) {
			inicializaDriverFactory();
		}
	}

	public static WebDriver inicializaDriverFactory() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dennis\\Documents\\Curso_Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static void finalizarDriverFactory() {

		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
