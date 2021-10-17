package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import drivers.DriverManager;
import factories.ExplicitWaitFactory;
import frameworkEnums.WaitStrategy;
import masterClasses.MasterWrapper;
import pageObjects.LandingPageObjects;
import reports.ExtentLogger;

public class LandingPage extends MasterWrapper implements LandingPageObjects {

	public LandingPage verifyLandingPage() {
		try {
			Assert.assertTrue(findElementPresence(divLandingPageHeading), "Not Landed in Landing Page");
			ExtentLogger.pass("Verified Landing Page Successfuly");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		return this;
	}

	public WorkFlowsPage navigateToWorkflows(String platform) {
		try {
			if (platform.equalsIgnoreCase("mobile")) {
				clickElementJS(iconHamburger);
				pauseFor(500);
			}
			clickElement(lnkWorkflows);

			Assert.assertTrue(findElementPresence(divWorkflowPageHeading), "Not Landed in Workflows Page");
			ExtentLogger.pass("Navigated to WorkFlows Page");
		} catch (Exception e) {
			Assert.fail("Unable to Navigate to Workflows Page. " + e.getMessage());
		}

		return new WorkFlowsPage();
	}

	public LandingPage openIntercom(String platform) {
		try {
			clickElement(btnIntercomOpen);
			switchToFrame(frameIntercom);
			ExtentLogger.pass("Opened Intercom Successfully");
		} catch (Exception e) {
			Assert.fail("Unable to Open Intercom. " + e.getMessage());
		}

		return this;
	}

	public LandingPage sendMessage(String message) {
		try {
			enterData(txtAreaMessageBox, message);
			clickElement(btnSendMessage);
			ExtentLogger.pass("Sent the Message Successfully.");
		} catch (Exception e) {
			Assert.fail("Unable to Send Message. " + e.getMessage());
		}

		return this;
	}

	public LandingPage verifyReply(String message) {

		try {
			String reply = "";
			ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, imgOperator);
			pauseFor(2000);
			List<WebElement> replies = getListOfElements(By.xpath(txtBotReplies.replace("<<>>", message)));

			for (WebElement element : replies)
				reply = reply + element.getText();

			ExtentLogger.pass("Verified Reply from Intercom. The Replies are: " + reply);
		} catch (Exception e) {
			Assert.fail("Unable to Verify Reply in Intercom. " + e.getMessage());
		}

		return this;
	}

	public LandingPage closeIntercom() {
		try {
			switchToFrame(2);
			clickElementJS(btnIntercomClose);
			ExtentLogger.pass("Closed the Intercom");
		} catch (Exception e) {
			Assert.fail("Unable to Close Intercom. " + e.getMessage());
		}

		return this;
	}

	public DemoPage selectBookDemo(String platform) {
		try {
			if (platform.equalsIgnoreCase("mobile")) {
				scrollToBottom();
				pauseFor(500);
				clickElement(By.id("demo-footer-button"));

			} else if (platform.equalsIgnoreCase("web")) {
				clickElement(btnBookDemo);
			}
			Assert.assertTrue(findElementPresence(divDemoPageHeading), "Not Landed in Demo Booking page");
			ExtentLogger.pass("Clicked Book Demo Button Successfully");
		} catch (Exception e) {
			Assert.fail("Unable to Click Book Demo Button. " + e.getMessage());
		}

		return new DemoPage();
	}

}
