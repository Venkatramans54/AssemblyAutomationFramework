package pageObjects;

import org.openqa.selenium.By;

public interface DemoPageObjects {
	
	String date="//button[@aria-label='October 23rd']//parent::td";
	By btnTimeSlot = By.xpath("(//div[@class='private-selectable-box__inner'])[1]");
	
	By txtFirstName=By.name("firstName");
	By txtLastName=By.name("lastName");
	By txtEmail=By.name("email");
	By txtPhone=By.name("phone");
	By selectApplicationType=By.name("chat_application");
	By txtOtherFlows=By.name("Are you interested in any other Flows?");
	
	By btnBack=By.xpath("//button[@data-selenium-test='back-button']");
	By btnConfirm=By.xpath("//button[@data-selenium-test='forward-button']");
	
	By divAcknowledege=By.xpath("//*[contains(text(),'Booking Confirmed')]");

}
