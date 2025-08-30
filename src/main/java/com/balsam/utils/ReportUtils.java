package com.balsam.utils;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class ReportUtils {

	private static int stepCounter = 1;

	public static void logStep(String message, WebDriver driver, boolean attachScreenshot) throws IOException {
	    String stepMessage = "Step " + stepCounter + ": " + message;

	    if (attachScreenshot) {
		    String path = ScreenshotUtils.capture(driver, message);
		    if (path != null) {
		    	ReportManager.getTest().info(stepMessage, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		    } else {
		    	ReportManager.getTest().info(stepMessage + " (screenshot failed)");
		    }
		} else {
			ReportManager.getTest().info(stepMessage);
		}

	    stepCounter++;
	}

    public static void logPass(String message, WebDriver driver) throws IOException {
        logStep("PASS: " + message, driver, true);
    }

    public static void logFail(String message, WebDriver driver) throws IOException {
        logStep("FAIL: " + message, driver, true);
    }
}
