package com.balsam.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.balsam.locators.SearchResultsPageLocators;
import com.balsam.utils.WaitUtils;

public class SearchResultsPage extends SearchResultsPageLocators{
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectResult(int position) {
    	
        List<WebElement> results = WaitUtils.waitForElementsVisible(driver, SearchResultsPageLocators.SEARCH_RESULTS, 5);
        System.out.println("SEARCH RESULTS = "+results);

        if (position > 0 && position <= results.size()) {
            results.get(position - 1).click(); // 0-based index in List
        } else {
            throw new IllegalArgumentException(
                "Invalid result position: " + position + ". Total results: " + results.size()
            );
        }
    }
    
}
