package com.balsam.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class WaitUtils {
    public static boolean isElementVisible(WebDriver driver, By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isElementNotVisible(WebDriver driver, By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            return true;
        }
    }
    
    public static void waitElementVisibility(WebDriver driver, By locator, int timeout) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static void waitElementInVisibility(WebDriver driver, By locator, int timeout) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    	 wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    
    public static List<WebElement> waitForElementsVisible(WebDriver driver, By locator, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public static WebElement waitForElementClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
    	return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
