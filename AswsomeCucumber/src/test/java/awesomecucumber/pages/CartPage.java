package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath= "//input[@title=\"Qty\"]")private WebElement quantityTxt;
    @FindBy(xpath ="//a[normalize-space()=\"Proceed to checkout\"]")
    private WebElement ProceedToCheckoutBtn;

    public int getProductQuantity() {
        int qty = Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(quantityTxt))
                .getAttribute("value"));
        return qty;
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOf(ProceedToCheckoutBtn)).click();
    }

}
