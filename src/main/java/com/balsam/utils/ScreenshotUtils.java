package com.balsam.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class ScreenshotUtils {

    // Replace illegal filename characters
    public static String sanitizeFileName(String input) {
        return input.replaceAll("[\\\\/:*?\"<>|]", "_");
    }

    /**
     * Capture a full-page screenshot, optionally waiting for important elements.
     * @param driver WebDriver instance
     * @param fileName Desired file name (sanitized automatically)
     * @param importantElements Elements to wait for before taking screenshot (optional)
     * @return Absolute path to screenshot file, or null if failed
     */
    public static String capture(WebDriver driver, String fileName, WebElement... importantElements) {
    	

    	
        File screenshotFolder = new File("screenshots");
        if (!screenshotFolder.exists()) screenshotFolder.mkdir();

        try {
            // Wait for important elements to be visible
        	new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));

            // Tiny pause to allow animations to settle
            Thread.sleep(100);

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            if (src.length() == 0) {  // file is empty
                Thread.sleep(500);
                src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            }

            // Sanitize + timestamp
            String safeFileName = sanitizeFileName(fileName) + "_" + System.currentTimeMillis();
            File dest = new File(screenshotFolder, safeFileName + ".png");

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return dest.getAbsolutePath();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
