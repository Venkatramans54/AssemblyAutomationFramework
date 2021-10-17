package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import frameworkConstants.FrameworkConstants;
import frameworkEnums.ConfigProperties;
import utilities.ApplicationPropertyUtils;

public class RetryAnalyzer implements IRetryAnalyzer{
	
	private int count=0;

	public boolean retry(ITestResult result) {
		boolean value=false;
		
		if(ApplicationPropertyUtils.get(ConfigProperties.RETRYFAILEDTESTCASES).equalsIgnoreCase("yes")){
			value=count<FrameworkConstants.getRetrycount();
			count++;
		}
		
		return value;
	}

}
