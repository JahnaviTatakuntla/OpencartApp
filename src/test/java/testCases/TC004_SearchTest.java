package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchTest extends BaseClass {

    // ------------------------------
    // Test Case 1: Special Characters
    // ------------------------------
    @Test(priority = 1, groups = {"Regression", "Master"})
    public void verifySearchWithSpecialCharacters() {
        logger.info("**** Starting Search Test - Special Characters ****");

        try {
            SearchPage sp = new SearchPage(driver);

            logger.info("Entering special characters...");
            sp.enterProductName("@#$%^");

            logger.info("Clicking search...");
            sp.clickSearch();

            logger.info("Validating 'No product found' message...");
            boolean noResult = sp.isNoProductMessageExists();
            Assert.assertTrue(noResult, "Expected: No product message should appear");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail();
        }

        logger.info("**** Finished Search Test - Special Characters ****");
    }


    // ------------------------------
    // Test Case 2: Partial Product Name
    // ------------------------------
    @Test(priority = 2, groups = {"Sanity", "Regression", "Master"})
    public void verifySearchWithPartialName() {
        logger.info("**** Starting Search Test - Partial Name ****");

        try {
            SearchPage sp = new SearchPage(driver);

            logger.info("Entering partial product keyword: Mac");
            sp.enterProductName("Mac");

            logger.info("Clicking search...");
            sp.clickSearch();

            logger.info("Validating product results...");
            Assert.assertTrue(sp.isProductListDisplayed(),
                    "Expected: products should be displayed for partial search keyword");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail();
        }

        logger.info("**** Finished Search Test - Partial Name ****");
    }


    // ------------------------------
    // Test Case 3: Case Insensitive Search
    // ------------------------------
    @Test(priority = 3, groups = {"Regression", "Master"})
    public void verifySearchCaseInsensitivity() {
        logger.info("**** Starting Search Test - Case Insensitivity ****");

        try {
            SearchPage sp = new SearchPage(driver);

            logger.info("Entering keyword in uppercase: MACBOOK");
            sp.enterProductName("MACBOOK");

            logger.info("Clicking search...");
            sp.clickSearch();

            logger.info("Validating results...");
            Assert.assertTrue(sp.isProductListDisplayed(),
                    "Expected: Search should be case-insensitive");

        } catch (Exception e) {
            logger.error("Test failed: " + e.getMessage());
            Assert.fail();
        }

        logger.info("**** Finished Search Test - Case Insensitivity ****");
    }
}
