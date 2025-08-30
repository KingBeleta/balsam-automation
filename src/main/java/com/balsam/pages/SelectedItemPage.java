package com.balsam.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.balsam.locators.CartPageLocators;
import com.balsam.locators.SelectedItemPageLocators;
import com.balsam.utils.FilterUtils;
import com.balsam.utils.GenericUtils;
import com.balsam.utils.WaitUtils;

public class SelectedItemPage {
	private WebDriver driver;
	private String selectedItemName;
	public static String SELECTED_ITEM_PRIZE_VALUE;
	

	public SelectedItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
    public void fetchSelectedItemName() {
        WaitUtils.isElementVisible(driver, SelectedItemPageLocators.SELECTED_ITEM_NAME, 5);
        selectedItemName = driver.findElement(SelectedItemPageLocators.SELECTED_ITEM_NAME).getText().split("®")[0].trim();
    }
	
    public String getStoredSelectedItemName() {
        return selectedItemName;
    }
    
    
	public void selectRandomOptionForHeight() throws InterruptedException {
		FilterUtils.selectRandomInStockOption(driver, SelectedItemPageLocators.HEIGHT_OPTIONS, SelectedItemPageLocators.OUT_OF_STOCK_INDICATOR, "Height");
	}
	
	public void selectRandomOptionForShape() throws InterruptedException {
		FilterUtils.selectRandomInStockOption(driver, SelectedItemPageLocators.SHAPE_OPTIONS, SelectedItemPageLocators.OUT_OF_STOCK_INDICATOR, "Shape");
	}
	
	public void selectRandomOptionForLights() throws InterruptedException {
FilterUtils.selectRandomInStockOption(driver, SelectedItemPageLocators.LIGHTS_OPTIONS, SelectedItemPageLocators.OUT_OF_STOCK_INDICATOR, "Lights");
	}
	
	public void selectRandomOptionForSetup() throws InterruptedException {
		FilterUtils.selectRandomInStockOption(driver, SelectedItemPageLocators.SETUP_OPTIONS, SelectedItemPageLocators.OUT_OF_STOCK_INDICATOR, "Setup");
	}
	
	public void addToCartSelectedItem() {
		GenericUtils.scrollIntoView(driver, SelectedItemPageLocators.ADD_TO_CART);
		GenericUtils.jsClick(driver, SelectedItemPageLocators.ADD_TO_CART);
	}
	
	public void validateSameItemNameIsAddedToCart() {
		WaitUtils.waitElementVisibility(driver, SelectedItemPageLocators.ITEM_NAME_ADDED_TO_CART, 5);
		String ItemAddedToCart = driver.findElement(SelectedItemPageLocators.ITEM_NAME_ADDED_TO_CART).getText().split("®")[0].trim();
		System.out.println("selectedItemName >> "+selectedItemName);
		System.out.println("ItemAddedToCart >> "+ItemAddedToCart);
		
		Assert.assertTrue(selectedItemName.contains(ItemAddedToCart));
	}
	
    public void fetchSelectedItemPrize() {
        WaitUtils.isElementVisible(driver, SelectedItemPageLocators.ITEM_ADDED_TO_CART_PRIZE_VALUE, 5);
        SELECTED_ITEM_PRIZE_VALUE = driver.findElement(SelectedItemPageLocators.ITEM_ADDED_TO_CART_PRIZE_VALUE).getText().replaceAll("[^0-9]", "").trim();
    }
    
    public String getStoredSelectedItemPrize() {
        return SELECTED_ITEM_PRIZE_VALUE;
    }
    
    public void viewCartViaAddToCartModal() {
    	WaitUtils.waitElementVisibility(driver, SelectedItemPageLocators.ITEM_ADDED_TO_CART_VIEW_CART_BUTTON, 5);
    	GenericUtils.jsClick(driver, SelectedItemPageLocators.ITEM_ADDED_TO_CART_VIEW_CART_BUTTON);
    	WaitUtils.waitElementVisibility(driver, CartPageLocators.SHOPPING_CART_HEADER, 5);
    	
    }
    
}
