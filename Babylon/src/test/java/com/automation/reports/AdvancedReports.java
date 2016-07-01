package com.automation.reports;



import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class AdvancedReports {
	
	static final ExtentReports extent = ExtentReports.get(AdvancedReports.class);
	static String reportLocation="C:\\Reports\\ExtentReport.html";
	
	public AdvancedReports(WebDriver driver){
		
	}
	
	
	public void  ReportClass(String file_type, String testcase)
	{
		extent.init(reportLocation, true);
		extent.config().documentTitle("Babylon APP");
		extent.config().reportHeadline("Appium TESTING");
		extent.startTest("Test case for "+file_type,"the validation for "+testcase);
		
	}
	
	public void InfoTest(String details)
	{
		
		extent.log(LogStatus.INFO, details);
		
	}
	public void PassTest(String details)
	{
		extent.log(LogStatus.PASS, details);
	}
	
	
	
	
}

