package com.balsam.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class FilterUtils {
	
    /**
     * Returns all elements found by the locator
     */
    public static List<WebElement> getOptions(WebDriver driver, By locator) {
        return driver.findElements(locator);
    }

    /**
     * Click a specific element by index
     * @throws InterruptedException 
     */
    public static void clickOptionByIndex(WebDriver driver, By locator, int index) throws InterruptedException {
        List<WebElement> options = getOptions(driver, locator);
        if (index < 0 || index >= options.size()) {
            throw new IndexOutOfBoundsException(
                "Index " + index + " out of bounds for locator: " + locator
            );
        }
        WaitUtils.waitForElementsVisible(driver, locator, 5);
        GenericUtils.scrollIntoView(driver, options.get(index));
        GenericUtils.jsClick(driver, options.get(index));
    }
    
    public static void selectRandomInStockOption(WebDriver driver, By optionsLocator, By outOfStockLocator, String specLabel) throws InterruptedException {
        List<WebElement> options = driver.findElements(optionsLocator);

        if (options.isEmpty()) {
            throw new RuntimeException("No options found for locator: " + optionsLocator);
        }

        Random random = new Random();
        Set<Integer> triedIndexes = new HashSet<>();
        boolean inStock = false;

        while (triedIndexes.size() < options.size()) {
            int index = random.nextInt(options.size());

            if (triedIndexes.contains(index)) {
                continue; // skip already tried options
            }

            triedIndexes.add(index);
            WebElement option = options.get(index);

            GenericUtils.scrollIntoView(driver, option);
            GenericUtils.jsClick(driver, option);

            Thread.sleep(1000); 

            // Check if OUT OF STOCK appears
            inStock = !WaitUtils.isElementVisible(driver, outOfStockLocator, 1);

            if (inStock) {
                // Capture screenshot of selected in-stock option
                ScreenshotUtils.capture(driver, specLabel + "_Selected");
                return; // valid option found, exit loop
            }
        }

        // None of the options are in stock
        throw new RuntimeException("All options for " + specLabel + " are OUT OF STOCK!");
    }


}
