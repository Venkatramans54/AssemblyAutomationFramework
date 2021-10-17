package frameworkConstants;

public class FrameworkConstants {
	
	private static final int EXPLICITWAIT = 10;
	private static final int IMPLICITWAIT = 10;
	private static final int PAGELOADTIMEOUT = 50;
	private static final int RETRYCOUNT = 1;
	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH+"/config/AppConfig.properties";
	private static final String JSONFILEPATH = RESOURCESPATH+"/inputJSON/";
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/reports/reports.html";

	
	public static int getImplicitwait() {
		return IMPLICITWAIT;
	}
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}


	public static int getPageloadtimeout() {
		return PAGELOADTIMEOUT;
	}


	public static int getRetrycount() {
		return RETRYCOUNT;
	}


	public static String getResourcespath() {
		return RESOURCESPATH;
	}
	
	public static String getJsonPath() {
		return JSONFILEPATH;
	}


	public static String getConfigfilepath() {
		return CONFIGFILEPATH;
	}


	public static String getExtentreportfolderpath() {
		return EXTENTREPORTFOLDERPATH;
	}


}
