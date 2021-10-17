package tests;

import java.util.Map;

import org.testng.annotations.Test;

import masterClasses.MasterWrapper;
import utilities.DataProviderUtils;

public class WebViewTests extends MasterWrapper{
	
	@Test(enabled=true)
	public void Intercom_Test() {
		landingPage.verifyLandingPage()
			.openIntercom("web")
			.sendMessage("Hello")
			.verifyReply("Hello");
	}
	
	@Test(enabled=true, dataProvider = "FormDetails", dataProviderClass = DataProviderUtils.class)
	public void BookDemo_Test(Map<String, String> formDetails) {
		landingPage.verifyLandingPage()
			.selectBookDemo("web")
			.selectDateAndTime()
			.fillDetailsAndSubmit(formDetails);
	}
	
	@Test(enabled=true)
	public void FeaturedCategory_Test() {
		landingPage.verifyLandingPage()
			.navigateToWorkflows("web")
			.getListOfCategories()
			.selectFeaturedList()
			.getFeaturedList();
	}
	
	

}
