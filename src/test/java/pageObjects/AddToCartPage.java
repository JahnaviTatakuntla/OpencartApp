package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    WebDriver driver;

    // Constructor initializes WebElements using PageFactory
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // =====================================================
    // Web Elements (Locators)
    // =====================================================

    // Search input box at the top
    @FindBy(name = "search")
    WebElement txtSearchBox;

    // Search button
    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement btnSearch;

    // Product link from search results (MacBook in this case)
    // You can update this locator for dynamic usage later
    @FindBy(linkText = "MacBook")
    WebElement linkProduct;

    // Add to Cart button on product details page
    @FindBy(id = "button-cart")
    WebElement btnAddToCart;

    // Success message displayed after adding product to cart
    @FindBy(css = "div.alert.alert-success")
    WebElement successMessage;

    // =====================================================
    // Action Methods
    // =====================================================

    // Enter a product name into the search box
    public void enterProductName(String product) {
        txtSearchBox.clear();                  // Clear any existing text
        txtSearchBox.sendKeys(product);        // Enter product name
    }

    // Click on Search button
    public void clickSearch() {
        btnSearch.click();
    }

    // Select the product from search results
    public void clickProduct() {
        linkProduct.click();
    }

    // Click the Add to Cart button on product page
    public void clickAddToCart() {
        btnAddToCart.click();
    }

    // Verify if the success message is displayed
    public boolean isSuccessMessageDisplayed() {
        try {
            return successMessage.isDisplayed();
        } 
        catch (Exception e) {
            return false;     // If element not found or not visible
        }
    }
}
