package com.balsam.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.balsam.locators.CartPageLocators;
import com.balsam.utils.GenericUtils;
import com.balsam.utils.WaitUtils;


public class CartPage {
	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateAddedItemToCartGotSamePrize() {
		WaitUtils.waitElementVisibility(driver, CartPageLocators.SHOPPING_CART_SUBTOTAL, 5);
		String ShoppingCartSubTotal = driver.findElement(CartPageLocators.SHOPPING_CART_SUBTOTAL).getText().replaceAll("[^0-9]", "").trim();
		
		System.out.println("ShoppingCartSubTotal >> "+ShoppingCartSubTotal);
		System.out.println("SelectedItemPage.SELECTED_ITEM_PRIZE_VALUE >> "+SelectedItemPage.SELECTED_ITEM_PRIZE_VALUE);
		
		Assert.assertTrue(SelectedItemPage.SELECTED_ITEM_PRIZE_VALUE.equals(ShoppingCartSubTotal));
	}
	
	public void validateCartValue(String ExpectedValue) throws InterruptedException {
		WaitUtils.waitElementVisibility(driver, CartPageLocators.SHOPPNG_CART_ITEM_COUNT, 5);
		String ShoppingCartItemCount = driver.findElement(CartPageLocators.SHOPPNG_CART_ITEM_COUNT).getText();
		Assert.assertTrue(ExpectedValue.equals(ShoppingCartItemCount));
	}
	
	public void removeItemToCart() {
		WaitUtils.waitElementVisibility(driver, CartPageLocators.SHOPPNG_CART_TRASH_ICON, 5);
		GenericUtils.jsClick(driver, CartPageLocators.SHOPPNG_CART_TRASH_ICON);
		WaitUtils.waitElementInVisibility(driver, CartPageLocators.SHOPPNG_CART_TRASH_ICON, 5);
	}
	
	public void validateItemInCarthasBeenRemoved() throws InterruptedException {
		Thread.sleep(1000); 
		Assert.assertTrue(WaitUtils.isElementVisible(driver, CartPageLocators.SHOPPING_CART_ITEM_REMOVED_INDICATOR, 5));
		
	}

}
