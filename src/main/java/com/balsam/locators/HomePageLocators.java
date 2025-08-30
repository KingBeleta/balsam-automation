package com.balsam.locators;

import org.openqa.selenium.By;

public class HomePageLocators {
	
	
	/**POP-UP/MODALS **/
	public static final By SHOPPING_FROM_DIFF_COUNTRY_MODAL = By.cssSelector("div[class='dy-bhca-popup']");
	public static final By SHOPPING_FROM_DIFF_COUNTRY_MODAL_CLOSE_BUTTON = By.xpath("//div[@class='dy-bhca-popup']/button");
	public static final By SHOPPING_FROM_DIFF_COUNTRY_MODAL_REDIRECT_TO_CANADA_BUTTON = By.xpath("//div[@class='dy-bhca-popup']//button[@id='bhca-link']");
	public static final By SHOPPING_FROM_DIFF_COUNTRY_MODAL_REDIRECT_TO_US_BUTTON = By.xpath("//div[@class='dy-bhca-popup']//button[@id='bhus-link']");
	
	
	
	/** PAGE HEADER ELEMENTS **/
    public static final By SEARCH_BOX = By.id("constructor-search-input"); 
    public static final By SEARCH_BUTTON = By.cssSelector("button[data-testid='constructor-search-submit']");
    
    
    /** COOKIE BANNER **/
    public static final By COOKIE_BANNER = By.id("cookieBanner");
    public static final By COOKIE_BANNER_CLOSE_BUTTON = By.id("bannerCloseButton");
}