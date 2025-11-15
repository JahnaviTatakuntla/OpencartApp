package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import testBase.BaseClass;

public class TC005_AddToCartTest extends BaseClass {

    // Test Case: Validate Add To Cart functionality
    @Test(priority = 1, groups = {"Sanity", "Regression", "Master"})
    public void verifyAddToCart() {

        logger.info("***** Starting TC005_AddToCartTest *****");

        try {
            // Creating Page Object
            AddToCartPage ac = new AddToCartPage(driver);

            // Step 1: Enter product name in search box
            logger.info("Searching for product: MacBook");
            ac.enterProductName("MacBook");

            // Step 2: Click on Search button
            logger.info("Clicking Search button");
            ac.clickSearch();

            // Step 3: Open product page from search results
            logger.info("Opening product page");
            ac.clickProduct();

            // Step 4: Click Add to Cart button
            logger.info("Clicking Add to Cart");
            ac.clickAddToCart();

            // Step 5: Validate success message
            logger.info("Validating success message");
            boolean msg = ac.isSuccessMessageDisplayed();
            Assert.assertTrue(msg, "Success message not displayed.");

        } 
        catch (Exception e) {
            // Handling any unexpected errors
            logger.error("Test Failed: " + e.getMessage());
            Assert.fail();
        }

        logger.info("***** Finished TC005_AddToCartTest *****");
    }
}
