package com.balsam.base;

import com.balsam.utils.ReportManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
	protected WebDriver driver;

	@BeforeClass
	public void setup() {
	    driver = DriverFactory.getDriver("chrome");

	    // Initialize report
	    String reportName = this.getClass().getSimpleName();
	    ReportManager.initReports(reportName);
	}


	@AfterMethod
	public void afterMethod() {
		ReportManager.flushReports();
	}

	@AfterClass
	public void teardown() {
		DriverFactory.quitDriver();
		ReportManager.flushReports();
	}
}
