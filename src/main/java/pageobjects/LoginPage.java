package pageobjects;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {



    private final By userName = By.name("username");
    private final By password = By.name("password");
    private final By loginButton = By.xpath("//button[contains(.,'Login')]");


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
}
