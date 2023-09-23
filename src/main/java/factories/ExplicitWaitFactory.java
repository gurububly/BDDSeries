package factories;

import constants.FrameworkConstants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitFactory {

    public static WebElement performExplicitWait(WaitStrategy waitStrategy, By by) {
        WebElement element = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaitTimeOut())).until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENECEOF) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaitTimeOut())).until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISIBLEOF) {
            element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitwaitTimeOut())).until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.NONE) {
            DriverManager.getDriver().findElement(by);
        }
        return element;
    }
}
