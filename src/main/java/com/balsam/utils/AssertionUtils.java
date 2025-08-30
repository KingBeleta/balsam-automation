package com.balsam.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class AssertionUtils {

	public static void assertTrue(boolean condition, String message, WebDriver driver) {
	    try {
	        Assert.assertTrue(condition, message);
	    } catch (AssertionError e) {
	        String path = ScreenshotUtils.capture(driver, message);
	        if (path != null) {
	            ReportManager.getTest().log(Status.FAIL, "✖ " + message,
	                MediaEntityBuilder.createScreenCaptureFromPath(path).build());
	        } else {
	            ReportManager.getTest().log(Status.FAIL, "✖ " + message + " (screenshot failed)");
	        }
	        throw e;
	    }
	}

    public static void assertEquals(Object actual, Object expected, String message, WebDriver driver) {
        assertTrue(actual.equals(expected), message, driver);
    }
}
