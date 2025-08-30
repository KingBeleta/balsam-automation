package com.balsam.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void initReports(String reportName) {
        if (extent == null) {
            extent = new ExtentReports(); // initialize it
        }

        String safeReportName = reportName.replaceAll("[\\\\/:*?\"<>|]", "_");
        String filePath = "reports/" + safeReportName + ".html";

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(filePath);
        extent.attachReporter(htmlReporter);
    }



    public static void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void flushReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
