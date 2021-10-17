package pageObjects;

import org.openqa.selenium.By;

public interface WorkFlowsObjects {

	By listCategories=By.xpath("//a[contains(@class,'template-category-wrapper')]//child::div");
	By lnkFeatured=By.xpath("//a[contains(@class,'template-category-wrapper')]//child::div[contains(text(),'Featured')]");
	By listFeatured=By.xpath("//div[contains(@class,'badge integrations-category')]");
	
	String itemFeatured = "(//div[contains(@class,'badge integrations-category')])[<<>>]//following::p";
}
