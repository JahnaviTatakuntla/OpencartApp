package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {

    WebDriver driver;

    // Constructor — initializes all WebElements using PageFactory
    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ======================================================
    // Web Elements (Locators)
    // ======================================================

    // Search input box on the header
    @FindBy(name = "search")
    WebElement txtSearchBox;

    // Search button right next to the search box
    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement btnSearch;

    // Product link from search results (MacBook)
    @FindBy(linkText = "MacBook")
    WebElement linkProduct;

    // Add to Wishlist button on product page (heart icon)
    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    WebElement btnWishList;

    // Message displayed after clicking wishlist (success or login-required)
    @FindBy(css = "div.alert")
    WebElement wishlistMessage;

    // ======================================================
    // Action Methods (Reusable Functions)
    // ======================================================

    // Enter product name inside search box
    public void enterProductName(String product) {
        txtSearchBox.clear();          // Clear any existing text
        txtSearchBox.sendKeys(product); // Type the product name
    }

    // Click on Search button
    public void clickSearch() {
        btnSearch.click();
    }

    // Click on the product link in search results
    public void clickProduct() {
        linkProduct.click();
    }

    // Click on Add to Wishlist (heart icon)
    public void clickAddToWishList() {
        btnWishList.click();
    }

    // Check if alert message is displayed after adding to wishlist
    public boolean isWishlistMessageDisplayed() {
        try {
            return wishlistMessage.isDisplayed();
        } catch (Exception e) {
            return false; // If element does not exist or not visible
        }
    }

    // Get the actual text of wishlist message (success or login required)
    public String getWishlistMessage() {
        try {
            return wishlistMessage.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
