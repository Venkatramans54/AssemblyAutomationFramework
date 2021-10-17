package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.Assert;

import factories.ExplicitWaitFactory;
import frameworkEnums.WaitStrategy;
import masterClasses.MasterWrapper;
import pageObjects.DemoPageObjects;
import reports.ExtentLogger;

public class DemoPage extends MasterWrapper implements DemoPageObjects {

	public DemoPage selectDateAndTime() {
		try {

			scrollToElement(By.xpath("(//iframe)[1]"));
			switchToFrame(0);
			clickElement(By.xpath(date));
			clickElement(btnTimeSlot);

			ExtentLogger.pass("Successfully Selected Date and Time.");
		} catch (Exception e) {
			Assert.fail("Unable to Select Date and Time. " + e.getMessage());
		}

		return this;
	}

	public DemoPage fillDetailsAndSubmit(Map<String, String> formDetails) {
		try {
			enterData(txtFirstName, formDetails.get("FIRSTNAME"));
			enterData(txtLastName, formDetails.get("LASTNAME"));
			enterData(txtEmail, formDetails.get("EMAIL"));
			enterData(txtPhone, formDetails.get("PHONE"));
			selectOption(selectApplicationType, 1);
			enterData(txtOtherFlows, formDetails.get("OTHERFLOWS"));
			clickElement(btnConfirm);
			pauseFor(5000);
			ExtentLogger.pass("Successfully Entered Details and Submitted the Form.");
		} catch (Exception e) {
			Assert.fail("Unable to Enter Details and Submit the Form.");
		}

		return this;
	}

	public DemoPage verifyAcknowledgement() {
		try {
			switchToFrame(0);
			ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLE, divAcknowledege);
			ExtentLogger.pass("Verified the Acknowledgement Message");
		} catch (Exception e) {
			Assert.fail("Unable to Verify Acknowledge Message. " + e.getMessage());
		}

		return this;
	}

}
