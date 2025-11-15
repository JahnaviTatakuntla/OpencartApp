package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ------------------------
    // Web Elements
    // ------------------------

    @FindBy(name = "search")
    WebElement txtSearchBox;

    @FindBy(css = "button.btn.btn-default.btn-lg")
    WebElement btnSearch;

    @FindBy(css = "div.alert.alert-danger, #content p")
    WebElement txtNoResultMsg;

    @FindBy(css = ".product-layout")
    WebElement productList;

    // ------------------------
    // Actions / Methods
    // ------------------------

    public void enterProductName(String product){
        txtSearchBox.clear();
        txtSearchBox.sendKeys(product);
    }

    public void clickSearch(){
        btnSearch.click();
    }

    public boolean isNoProductMessageExists(){
        try {
            return txtNoResultMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isProductListDisplayed(){
        try {
            return productList.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}