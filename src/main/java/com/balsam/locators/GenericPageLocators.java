package com.balsam.locators;

import org.openqa.selenium.By;

public class GenericPageLocators {
	
	
	 public static final By POPUP = By.xpath("//div[contains(@class,'needsclick')]//div[@data-testid='POPUP']");
	 public static final By POPUP_CLOSE_BUTTON = By.xpath("//div[contains(@class,'needsclick')]//div[@data-testid='POPUP']//button[*='Close dialog']");

}
