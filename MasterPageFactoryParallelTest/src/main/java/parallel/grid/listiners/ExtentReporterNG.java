package parallel.grid.listiners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	
	public static ExtentSparkReporter reporter;
	public static ExtentReports extent;
	
	
	public static ExtentReports extentReportGenerator() {
		
	String REPORT_PATH= (System.getProperty("user.dir") + "\\extentReport_output\\index.html");
	ExtentSparkReporter reporter =new ExtentSparkReporter(REPORT_PATH); 
	reporter.config().setReportName("PARALLEL TEST EXECUTION");
	reporter.config().setDocumentTitle("CAR GURUJI SITE QA TESTING");
	reporter.config().setTheme(Theme.STANDARD);
	reporter.config().setEncoding("utf-8");
	reporter.config().setTimeStampFormat("HH:MM:SS");
	//reporter.config().setProtocol("https");
	
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Author Name", "Michael Ray");
	return extent;
	

}

}
