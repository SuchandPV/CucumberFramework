package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@title=\"View cart\"]") private WebElement viewCartBtn;

    public void addToCart(String productName){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
        By addToCartBtn = By.xpath("//a[@aria-label=\"Add “"+ productName +"” to your cart\"]");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
    }
    public void ViewCart(){
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }

}
