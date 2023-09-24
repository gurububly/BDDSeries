package pageobjects;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {


    private final By userName = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//button[contains(.,'Login')]");

    private final By invalidCredentialMessage = By.xpath("//p[.='Invalid credentials']");


    public void enterUserName(String username) {
        // DriverManager.getDriver().findElement(userName).sendKeys(username);
        sendKeys(WaitStrategy.VISIBLEOF, userName, username);
    }

    public void enterPassword(String pass) {
        //DriverManager.getDriver().findElement(password).sendKeys(pass);
        sendKeys(WaitStrategy.VISIBLEOF, password, pass);
    }

    public void clickLogin() {
        //DriverManager.getDriver().findElement(loginButton).click();
        click(WaitStrategy.CLICKABLE, loginButton);
    }

    public String getLoginErrorMessage() {
        ExplicitWaitFactory.performExplicitWait(WaitStrategy.VISIBLEOF,invalidCredentialMessage);
        return DriverManager.getDriver().findElement(invalidCredentialMessage).getText();
    }
}
