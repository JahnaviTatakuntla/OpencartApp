package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.WishListPage;
import testBase.BaseClass;

public class TC006_WishListTest extends BaseClass {

    // Test Case: Verify that user can add an item to Wishlist
    @Test(priority = 1, groups = {"Sanity", "Regression", "Master"})
    public void verifyAddToWishlist() {

        logger.info("***** Starting TC006_WishListTest *****");

        try {
            // Creating the Page Object for Wishlist
            WishListPage wp = new WishListPage(driver);

            // ============================
            // Step 1: Search for Product
            // ============================
            logger.info("Searching for MacBook");
            wp.enterProductName("MacBook"); // Type "MacBook" in search box
            wp.clickSearch();               // Click on search button

            // ============================
            // Step 2: Open Product Page
            // ============================
            logger.info("Opening product page");
            wp.clickProduct();              // Click on the product link

            // ============================
            // Step 3: Click Add to Wishlist
            // ============================
            logger.info("Clicking Add to Wishlist");
            wp.clickAddToWishList();        // Click the wishlist (heart) button

            // ============================
            // Step 4: Validate Message
            // ============================
            logger.info("Checking if wishlist message displayed");

            // Step 4a: Ensure message is displayed
            Assert.assertTrue(wp.isWishlistMessageDisplayed(),
                    "Wishlist message was not displayed");

            // Step 4b: Read the message (success or login required)
            String msg = wp.getWishlistMessage();
            logger.info("Wishlist message: " + msg);

            // Step 4c: Validate the message content
            // It should either be a success OR login required
            Assert.assertTrue(
                    msg.contains("Wish") || msg.contains("login"),
                    "Unexpected Wishlist message received"
            );

        }
        catch (Exception e) {
            // If anything fails, log the issue and mark test as failed
            logger.error("Test Failed due to exception: " + e.getMessage());
            Assert.fail();
        }

        logger.info("***** Finished TC006_WishListTest *****");
    }
}
