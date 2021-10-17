package reports;

import java.util.Objects;

import com.aventstack.extentreports.MediaEntityBuilder;

import frameworkEnums.ConfigProperties;
import utilities.ApplicationPropertyUtils;
import utilities.ScreenshotUtils;

public class ExtentLogger {

	public static void pass(String message) {
		if (!Objects.isNull(ExtentReportManager.getExtentTest())) {
			if (ApplicationPropertyUtils.get(ConfigProperties.SCREENSHOTFORPASSEDSTEPS).equalsIgnoreCase("yes")) {
				ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder
						.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			} else {
				ExtentReportManager.getExtentTest().pass(message);
			}
			
			if(ApplicationPropertyUtils.get(ConfigProperties.LOGSTEPSINCONSOLE).equalsIgnoreCase("yes")) {
				System.out.println("-->"+message);
			}
		}
	}

	public static void fail(String message) {
		if (!Objects.isNull(ExtentReportManager.getExtentTest())) {
			ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			
			System.out.println("-->"+message);
		}
	}

	public static void skip(String message) {
		if (!Objects.isNull(ExtentReportManager.getExtentTest())) {
			ExtentReportManager.getExtentTest().skip(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			
			System.out.println("-->"+message);
		}
	}

}
