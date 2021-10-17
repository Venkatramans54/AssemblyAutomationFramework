package tests;

import java.util.Map;

import org.testng.annotations.Test;

import masterClasses.MasterWrapper;
import utilities.DataProviderUtils;

public class MobileViewTests extends MasterWrapper{
	
	@Test(enabled=true)
	public void Intercom_Test() {
		landingPage.verifyLandingPage()
			.openIntercom("mobile")
			.sendMessage("Hello")
			.verifyReply("Hello");
	}
	
	@Test(enabled=true, dataProvider = "FormDetails", dataProviderClass = DataProviderUtils.class)
	public void BookDemo_Test(Map<String, String> formDetails) {
		landingPage.verifyLandingPage()
			.selectBookDemo("mobile")
			.selectDateAndTime()
			.fillDetailsAndSubmit(formDetails);
	}
	
	@Test(enabled=true)
	public void FeaturedCategory_Test() {
		landingPage.verifyLandingPage()
			.navigateToWorkflows("mobile")
			.getListOfCategories()
			.selectFeaturedList()
			.getFeaturedList();
	}

}
