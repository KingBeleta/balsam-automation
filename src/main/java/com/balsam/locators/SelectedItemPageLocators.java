package com.balsam.locators;

import org.openqa.selenium.By;

public class SelectedItemPageLocators {
	
	 /**SELECTED ITEM PAGE **/
	 public static final By SELECTED_ITEM_NAME = By.xpath("//div[contains(@class,'productDetailNameRating_product')]/h1");
	 public static final By HEIGHT = By.xpath("//div[@id='product_filter_height']");
	 public static final By HEIGHT_OPTIONS = By.xpath("//div[@aria-labelledby='product_filter_height']//span[contains(@class,'text-break renderSelectBoxFilterItem')]");
	 public static final By SHAPE = By.xpath("//div[@id='product_filter_shape']");
	 public static final By SHAPE_OPTIONS = By.xpath("//div[@aria-labelledby='product_filter_shape']//span[contains(@class,'text-break renderSelectBoxFilterItem')]");
	 public static final By LIGHTS = By.xpath("//div[@id='product_filter_lights']");
	 public static final By LIGHTS_OPTIONS = By.xpath("//div[@aria-labelledby='product_filter_lights']//span[contains(@class,'text-break renderSelectBoxFilterItem')]");
	 public static final By SETUP = By.xpath("//div[@id='product_filter_setup']");
	 public static final By SETUP_OPTIONS = By.xpath("//div[@aria-labelledby='product_filter_setup']//span/span[contains(@class,'productConfiguratorTreeSetup')]");
	 public static final By ADD_TO_CART = By.xpath("//div[contains(@class,'productDetailContainer')]/button[text()='Add to Cart']");
	 public static final By COMPARE = By.xpath("//div[contains(@class,'productDetailContainer')]/button[text()='Compare]");
	 public static final By ADD_TO_FAVORITES = By.xpath("//div[contains(@class,'productDetailContainer')]//button[@aria-label='Add to favorites']");
	 public static final By ITEM_NAME_ADDED_TO_CART = By.xpath("//div[contains(@class,'productAddToCartModal_title')]/span");
	 public static final By OUT_OF_STOCK_INDICATOR = By.xpath("//span[text()='OUT OF STOCK']");
	 
	 
	 /**PRODCUT ADDED TO CART MODAL**/
	 public static final By ITEM_ADDED_TO_CART_PRIZE_VALUE = By.xpath("//div[contains(@class,'productAddToCartModal')]/span[text()='Price']/following-sibling::span");
	 public static final By ITEM_ADDED_TO_CART_VIEW_CART_BUTTON = By.xpath("//div[contains(@class,'productAddToCartModal')]/button[text()='View Cart']");
}
