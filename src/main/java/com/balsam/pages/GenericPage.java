package com.balsam.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.balsam.locators.GenericPageLocators;

import com.balsam.utils.AssertionUtils;
import com.balsam.utils.WaitUtils;

public class GenericPage extends GenericPageLocators {
	private WebDriver driver;

	public GenericPage(WebDriver driver) {
		this.driver = driver;
	}

	public void closeGenericModal() throws IOException {
		if (WaitUtils.isElementVisible(driver, GenericPageLocators.POPUP, 5)) {
			driver.findElement(GenericPageLocators.POPUP_CLOSE_BUTTON).click();
		}

		AssertionUtils.assertTrue(WaitUtils.isElementNotVisible(driver, GenericPageLocators.POPUP, 5),
				"Country modal should be closed", driver);

	}

}
