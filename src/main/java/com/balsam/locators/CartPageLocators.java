package com.balsam.locators;

import org.openqa.selenium.By;

public class CartPageLocators {

	public static final By SHOPPING_CART_HEADER = By.xpath("//div[contains(@class,'CartContainer')]//h2");
	public static final By SHOPPING_CART_SUBTOTAL = By.xpath("//span[contains(@class,'orderSummaryCard_title')]/following-sibling::span[@class='text-end']//span");
	public static final By SHOPPNG_CART_ITEM_COUNT = By.xpath("//a[contains(@aria-label,'Cart')]/span");
	public static final By SHOPPNG_CART_TRASH_ICON = By.xpath("//button/span[contains(@class,'cartProductDetailItem_delete-icon')]");
	public static final By SHOPPING_CART_ITEM_REMOVED_INDICATOR = By.xpath("//div[contains(@class,'cartProductDetailItem')]/ul");
}
