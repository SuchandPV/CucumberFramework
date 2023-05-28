package awesomecucumber.hooks;

import org.openqa.selenium.WebDriver;

import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
    private WebDriver driver;

    @Before
    public void before() {
        driver = DriverFactory.initializeDriver();
    }

    @After
    public void after() {
        driver.quit();
    }

}
