package masterClasses;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.google.common.util.concurrent.Uninterruptibles;

import drivers.Driver;
import drivers.DriverManager;
import factories.ExplicitWaitFactory;
import frameworkEnums.WaitStrategy;
import pages.LandingPage;

public class MasterWrapper {

	protected LandingPage landingPage;
	protected static ThreadLocal<String> testThread = new ThreadLocal<>();

	public String getTestName() {
		return testThread.get();
	}

	public void setTestName(String testName) {
		testThread.set(testName);
	}

	@Parameters("platform")
	@BeforeMethod
	protected void methodSetup(Method method, @Optional("web") String platform) {
		Driver.initDriver(platform);
		landingPage = new LandingPage();
		setTestName(method.getName());
	}

	@AfterMethod
	protected void methodTearDown() {
		Driver.quitDriver();
	}

	public boolean findElementPresence(By locator) {
		int size = 0;
		try {
			size = DriverManager.getDriver().findElements(locator).size();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return size > 0 ? true : false;
	}

	public void clearData(By locator) {
		ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator);
		DriverManager.getDriver().findElement(locator).clear();
	}

	public void enterData(By locator, String data) {
		try {
			ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator);
			DriverManager.getDriver().findElement(locator).sendKeys(data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getData(By locator) throws Exception {
		String data = "";
		try {
			ExplicitWaitFactory.performExplicitWait(WaitStrategy.PRESENCE, locator);
			data = DriverManager.getDriver().findElement(locator).getText();
		} catch (Exception e) {
			throw new Exception("Unable to Read Data from Element with Locator " + locator);
		}
		return data;
	}

	public void clickElement(By locator) {
		DriverManager.getDriver().findElement(locator).click();
	}

	public void clickElementJS(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].click()", DriverManager.getDriver().findElement(locator));
	}

	public void selectOption(By locator, String data) {
		try {
			Select select = new Select(DriverManager.getDriver().findElement(locator));
			select.selectByValue(data);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollToElement(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", DriverManager.getDriver().findElement(locator));
	}

	public void selectOption(By locator, int idx) {
		try {
			Select select = new Select(DriverManager.getDriver().findElement(locator));
			select.selectByIndex(idx);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void switchToFrame(String frameName) {
		DriverManager.getDriver().switchTo().frame(frameName);
	}

	public void switchToFrame(int frameId) {
		DriverManager.getDriver().switchTo().frame(frameId);
	}
	
	public void pauseFor(long milliSecs) {
		Uninterruptibles.sleepUninterruptibly(milliSecs, TimeUnit.MILLISECONDS);
	}

	public List<WebElement> getListOfElements(By locators) {
		List<WebElement> list = new ArrayList<>();
		try {
			list = DriverManager.getDriver().findElements(locators);
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}
}
