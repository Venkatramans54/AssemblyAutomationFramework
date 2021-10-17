package factories;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

	public static WebDriver createDriverSession(String browser, String platform) {

		WebDriver driver = null;
		ChromeOptions options=new ChromeOptions();
		Map<String, String> mobileEmulation=new HashMap<>();
		
		if(platform.equalsIgnoreCase("mobile")) {
			mobileEmulation.put("deviceName", "iPhone X");
			options.setExperimentalOption("mobileEmulation", mobileEmulation);
		}
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		return driver;
	}

}
