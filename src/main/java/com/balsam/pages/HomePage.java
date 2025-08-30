package com.balsam.pages;

import com.balsam.locators.HomePageLocators;
import com.balsam.utils.AssertionUtils;
import com.balsam.utils.WaitUtils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToHomePage() {
		driver.get("https://www.balsamhill.com/");

	}

	public void closeDifferentCountryModal() throws IOException {
		if (WaitUtils.isElementVisible(driver, HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL, 5)) {
			driver.findElement(HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL_CLOSE_BUTTON).click();
		}

		AssertionUtils.assertTrue(
				WaitUtils.isElementNotVisible(driver, HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL, 5),
				"Country modal should be closed", driver);

	}

	public void shopToDifferentCountryModal(String country) throws IOException {
		if (WaitUtils.isElementVisible(driver, HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL, 5)) {

			if (null != country && country.equalsIgnoreCase("US")) {
				driver.findElement(HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL_REDIRECT_TO_US_BUTTON).click();

			} else if (null != country && country.equalsIgnoreCase("CA")) {
				driver.findElement(HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL_REDIRECT_TO_CANADA_BUTTON).click();

			}
		}
		AssertionUtils.assertTrue(
				WaitUtils.isElementNotVisible(driver, HomePageLocators.SHOPPING_FROM_DIFF_COUNTRY_MODAL, 5),
				"Country modal should be closed", driver);

	}

	public void closeCookieBanner() throws IOException {
		if (WaitUtils.isElementVisible(driver, HomePageLocators.COOKIE_BANNER, 5)) {
			driver.findElement(HomePageLocators.COOKIE_BANNER_CLOSE_BUTTON).click();
		}

		AssertionUtils.assertTrue(WaitUtils.isElementNotVisible(driver, HomePageLocators.COOKIE_BANNER, 5),
				"Cookie Banner should be closed", driver);
	}

	public void searchForItem(String item) {
		driver.findElement(HomePageLocators.SEARCH_BOX).sendKeys(item);
		driver.findElement(HomePageLocators.SEARCH_BUTTON).click();
	}
	

}
