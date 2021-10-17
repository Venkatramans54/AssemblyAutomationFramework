package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import masterClasses.MasterWrapper;
import pageObjects.WorkFlowsObjects;
import reports.ExtentLogger;

public class WorkFlowsPage extends MasterWrapper implements WorkFlowsObjects{

	public WorkFlowsPage getListOfCategories() {
		try {
			List<WebElement> categoryList=getListOfElements(listCategories);
			
			if(categoryList.size()>0) {
				System.out.println("Multiple items are displayed");
			} else {
				System.out.println("No Items Displayed");
			}
			ExtentLogger.pass("Got List of Categories");
		} catch (Exception e) {
			Assert.fail("Unable to Read the Category List");
		}
		
		return this;
	}
	
	public WorkFlowsPage selectFeaturedList() {
		try {
			clickElement(lnkFeatured);
		} catch (Exception e) {
			Assert.fail("Unable to Select Featured List. "+e.getMessage());
		}
		
		return this;
	}
	
	public WorkFlowsPage getFeaturedList() {
		try {
			String data="";
			List<WebElement> featuredList=getListOfElements(listFeatured);
			
			for(int i=0;i<featuredList.size();i++) 
				data=data+featuredList.get(i).getText()+": "+getData(By.xpath(itemFeatured.replace("<<>>", String.valueOf(i+1))))+"\n";
			
			ExtentLogger.pass("Featured Lists are Read Successfully. The Data is: \n"+data);
			
		} catch (Exception e) {
			Assert.fail("Unable to Read Featured List. "+e.getMessage());
		}
		
		return this;
	}
}
