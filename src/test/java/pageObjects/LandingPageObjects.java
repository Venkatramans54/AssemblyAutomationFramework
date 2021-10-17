package pageObjects;

import org.openqa.selenium.By;

public interface LandingPageObjects {
	
	By btnIntercomOpen = By.xpath("//div[contains(@class,'intercom-lightweight-app-launcher-icon-open')]");
	By txtAreaMessageBox = By.name("message");
	By btnSendMessage = By.xpath("//button[contains(@class,'intercom-composer-send-button')]");
	By imgOperator = By.xpath("//img[contains(@src,'operator')]");
	
	String txtBotReplies="//div[contains(text(),'<<>>')]//following::div[contains(@class,'intercom-comment')]";
	By btnIntercomClose = By.xpath("//div[@aria-label='Close Intercom Messenger']");
	
	String frameIntercom = "intercom-messenger-frame";
	By btnBookDemo = By.id("demo-header-button");
	By lnkWorkflows=By.xpath("//a[contains(text(),'Workflows')]");
	By btnDemo=By.name("demo-header-button");
	
	By divLandingPageHeading=By.xpath("//h1[contains(text(),'Welcome to your Digital HQ')]");
	By divWorkflowPageHeading=By.xpath("//h1[contains(text(),'workflows')]");
	By divDemoPageHeading=By.xpath("//h1[contains(text(),'boost?')]");
	By iconHamburger=By.xpath("//div[@aria-label='menu']");

}
