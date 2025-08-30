package com.balsam.tests;

import com.balsam.base.BaseTest;
import com.balsam.pages.CartPage;
import com.balsam.pages.GenericPage;
import com.balsam.pages.HomePage;
import com.balsam.pages.SearchResultsPage;
import com.balsam.pages.SelectedItemPage;
import com.balsam.utils.ReportManager;
import com.balsam.utils.ReportUtils;

import java.io.IOException;

import org.testng.annotations.Test;

public class BalsamCartTest extends BaseTest {
	
	
	@Test
	public void searchChristmasTree() throws IOException, InterruptedException {
		ReportManager.createTest("Search Christmas Tree Test");

	    GenericPage genericPage = new GenericPage(driver);
	    HomePage homePage = new HomePage(driver);
	    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
	    SelectedItemPage selectedItemPage = new SelectedItemPage(driver);
	    CartPage cartPage = new CartPage(driver);

	    homePage.goToHomePage();
	    ReportUtils.logStep("Navigated to home page", driver, true);

	    /**Added extra step because of my current location**/
	    homePage.shopToDifferentCountryModal("CA");
	    ReportUtils.logStep("Shopping redirected to CA", driver, true);
	    
	    homePage.closeCookieBanner();
	    ReportUtils.logStep("Cookie Banner was closed successfully", driver, true);
	    
	    homePage.searchForItem("Christmas Tree");
	    ReportUtils.logStep("Searched for 'Christmas Tree'", driver, true);
	    
	    searchResultsPage.selectResult(3);
	    ReportUtils.logStep("Select Trird Result'", driver, true);
	    
	    genericPage.closeGenericModal();
	    ReportUtils.logStep("Generic POPUP promotion was closed successfully", driver, true);
	    
	    selectedItemPage.fetchSelectedItemName();
	    ReportUtils.logStep("Get Selected Item Name", driver, true);
	    
	    selectedItemPage.selectRandomOptionForHeight();
	    ReportUtils.logStep("Select Random Option for Height", driver, true);
	    
	    selectedItemPage.selectRandomOptionForShape();
	    ReportUtils.logStep("Select Random Option for Shape", driver, true);
	    
	    selectedItemPage.selectRandomOptionForLights();
	    ReportUtils.logStep("Select Random Option for Lights", driver, true);
	    
	    selectedItemPage.selectRandomOptionForSetup();
	    ReportUtils.logStep("Select Random Option for Setup", driver, true);
	    
	    
	    selectedItemPage.addToCartSelectedItem();
	    ReportUtils.logStep("Add Item to Cart", driver, true);
	    
	    selectedItemPage.validateSameItemNameIsAddedToCart();
	    ReportUtils.logPass("Validate the Item Added to Cart is the one that was selected", driver);
	    
	    selectedItemPage.fetchSelectedItemPrize();
	    ReportUtils.logStep("Get Selected Item Prize", driver, true);
	    
	    selectedItemPage.viewCartViaAddToCartModal();
	    ReportUtils.logStep("Viewing Cart", driver, true);
	   
	    cartPage.validateAddedItemToCartGotSamePrize();
	    ReportUtils.logPass("Validate the Item Added to Cart has the same amount in Cart Page and Shopping Page", driver);
	    
	    cartPage.validateCartValue("1");
	    ReportUtils.logPass("Validate the Cart has 1 item added", driver);
	    
	    cartPage.removeItemToCart();
	    ReportUtils.logPass("Remove the Item in Cart", driver);
	    
	    cartPage.validateItemInCarthasBeenRemoved();
	    ReportUtils.logPass("Validate that the Item in Cart has been removed", driver);

	    
	    ReportUtils.logPass("Test Completed!", driver);
	      
	}

}
