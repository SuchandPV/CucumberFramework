package awesomecucumber.pages;

import awesomecucumber.domainObjects.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Map;

public class CheckoutPage extends BasePage
{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="billing_first_name")private WebElement firstNameFld;
    @FindBy(id ="billing_last_name")private WebElement lastNameFld;
    @FindBy(id ="billing_address_1")private WebElement addressLine1Fld;
    //	@FindBy(id = "select2-billing_state-container")private WebElement stateFld;
    @FindBy(id = "billing_city")private WebElement cityFld;
    @FindBy(id = "billing_postcode")private WebElement zipFld;
    @FindBy(id = "billing_email")private WebElement emailFld;
    @FindBy(id ="place_order")private WebElement placeOrderBtn;

    public void EnterBillingAddress(BillingDetails billingDetails) {
        wait.until(ExpectedConditions.visibilityOf(firstNameFld)).clear();
        firstNameFld.sendKeys(billingDetails.getBillingFirstName());
        lastNameFld.sendKeys(billingDetails.getBillingLastName());
        addressLine1Fld.sendKeys(billingDetails.getBillingCity());
        cityFld.sendKeys(billingDetails.getBillingState());
        zipFld.sendKeys(billingDetails.getBillingZip());
        emailFld.sendKeys(billingDetails.getBillingEmail());
    }

    public void placeOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
    }
}

