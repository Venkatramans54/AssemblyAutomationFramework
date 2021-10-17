package drivers;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import factories.DriverFactory;
import frameworkConstants.FrameworkConstants;
import frameworkEnums.ConfigProperties;
import utilities.ApplicationPropertyUtils;

public final class Driver {
	WebDriver driver = null;
	public static void initDriver(String platform) {
		String appURL=ApplicationPropertyUtils.get(ConfigProperties.APPURL);
		String browser=ApplicationPropertyUtils.get(ConfigProperties.BROWSER);
		
		if(Objects.isNull(DriverManager.getDriver())) {
			try {
				DriverManager.setDriver(DriverFactory.createDriverSession(browser, platform));
			} catch (Exception e) {
				// TODO: handle exception
				throw new RuntimeException("Unable to Configure Driver. "+e.getMessage());
			}
		}
		DriverManager.getDriver().get(appURL);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(FrameworkConstants.getImplicitwait(), TimeUnit.SECONDS);
		DriverManager.getDriver().manage().timeouts().pageLoadTimeout(FrameworkConstants.getPageloadtimeout(), TimeUnit.SECONDS);
		
	}
	
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
