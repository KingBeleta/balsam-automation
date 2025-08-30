package com.balsam.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericUtils {
	
	public static void scrollIntoView(WebDriver driver, WebElement element) {
	    ((JavascriptExecutor) driver).executeScript(
	        "var y = arguments[0].getBoundingClientRect().top + window.pageYOffset - 150;" +
	        "window.scrollTo(0, y);", // remove smooth scroll to prevent jump
	        element
	    );
	}
	
    public static void scrollIntoView(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript(
            "var y = arguments[0].getBoundingClientRect().top + window.pageYOffset - 150;" +
            "window.scrollTo(0, y);", 
            element
        );
    }
	
	
    public static void jsClick(WebDriver driver, WebElement element) {
    	WaitUtils.waitForElementClickable(driver, element, 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    

    public static void jsClick(WebDriver driver, By locator) {
        WebElement element = WaitUtils.waitForElementClickable(driver, driver.findElement(locator), 5);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

   

}
