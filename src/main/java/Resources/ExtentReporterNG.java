package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.ReporterConfigurable;

public class ExtentReporterNG {
	public static ExtentReports getReporterObject() {
	String path = System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setDocumentTitle("testing");
	reporter.config().setReportName("Automation");
	
	ExtentReports er=new ExtentReports();
	er.attachReporter(reporter);
	return er;
	
	
	}
}
