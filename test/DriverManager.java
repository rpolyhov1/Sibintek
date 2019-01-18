package test;

import java.io.File;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {
	static WebDriver driver;

	public static WebDriver getDriver() {
		ChromeOptions options = new ChromeOptions();
		if (driver == null) {
			HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
			chromePrefs.put("download.default_directory", new File("").getAbsolutePath() + "\\RESULT\\");
			chromePrefs.put("disable-popup-blocking", "true");
			options.setExperimentalOption("prefs", chromePrefs);
			//options.addArguments("--headless");//headless: запуск без пользовательского интерфейса
			driver = new ChromeDriver(options);
		}
		return driver;

	}

}
