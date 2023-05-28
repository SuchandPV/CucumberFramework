package awesomecucumber;

import java.util.List;
import java.util.Map;

import awesomecucumber.domainObjects.BillingDetails;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckoutPage;
import awesomecucumber.pages.StorePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import awesomecucumber.factory.DriverFactory;
public class StepDef {
    private WebDriver driver;
    private BillingDetails billingDetails;

    @Given("I'm on the store page")
    public void i_m_on_the_store_page() throws Throwable {
        StorePage storePage = new StorePage(driver);
        storePage.openUrl("https://askomdch.com/stor");
    }
    @When("I add a {string} to the cart")
    public void i_add_a_to_the_cart(String string) {

        StorePage storePage = new StorePage(driver);
        storePage.ViewCart();

    }
    @Then("I should see {int} {string} in the cart")
    public void i_should_see_in_the_cart(int int1, String string) throws Throwable {
        Thread.sleep(1000);
        Assert.assertEquals(int1, new CartPage(driver).getProductQuantity());

    }

    @Given("I'm a guest user")
    public void i_m_a_guest_user() {
        StorePage storePage = new StorePage(driver);
        storePage.openUrl("https://askomdch.com/stor");

    }

    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() throws Throwable {
        StorePage storePage =new StorePage(driver);
        storePage.addToCart("Blue Shoes");
        Thread.sleep(3000);
        storePage.ViewCart();
    }

    @Given("I'm on the checkout page")
    public void i_m_on_the_checkout_page() {
        CartPage cartPage = new CartPage(driver);
        cartPage.proceedToCheckout();
    }

    @When("I provide billing details")
    public void i_provide_billing_details(BillingDetails billingDetails) {
        this. billingDetails = billingDetails;
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.EnterBillingAddress(billingDetails);

    }

    @When("I place an order")
    public void i_place_an_order() {
        By placeOrderBtn = By.id("place_order");
        driver.findElement(placeOrderBtn).click();
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() throws Throwable {
        By successTxt = By.cssSelector(".woocommerce-notice");
        Thread.sleep(2000);
        String text = driver.findElement(successTxt).getText();
        Assert.assertEquals(text, "Thank you. Your order has been received.");
        driver.close();
        driver.quit();
    }


}
