package pageobjects;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected void sendKeys(WaitStrategy waitStrategy, By by, String value) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        //DriverManager.getDriver().findElement(by).sendKeys(value);
        element.sendKeys(value);
    }

    protected void click(WaitStrategy waitStrategy, By by) {
        WebElement element = ExplicitWaitFactory.performExplicitWait(waitStrategy, by);
        //DriverManager.getDriver().findElement(by).click();
        element.click();
    }

    protected String getPageTitle() {
        return DriverManager.getDriver().getTitle();
    }
}
