package reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import frameworkConstants.FrameworkConstants;

public final class ExtentReport {

	private static ExtentReports extent;


	public static void initReports() {
		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentreportfolderpath()); 
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Results");
			spark.config().setReportName("Assembly");
		}
	}

	public static void flushReports(){
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		
		ExtentReportManager.unload();
	}

	public static void createTest(String testcasename) {
		ExtentReportManager.setExtentTest(extent.createTest(testcasename));
	}
	
}
