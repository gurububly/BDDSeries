package pageobjects;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class HRMHomePage extends BasePage {

    private final By homePageTitle = By.xpath("//h6[.='Dashboard']");
    private final By logoutMenu = By.xpath("//span[@class='oxd-userdropdown-tab']/p");
    private final By logoutButton = By.xpath("//a[.='Logout']");

    public String getHomePageTitle() {
        // return DriverManager.getDriver().getTitle();
        return getPageTitle();

    }

    public void selectLogoutMenu() {

        //DriverManager.getDriver().findElement(logoutMenu).click();
        click(WaitStrategy.CLICKABLE, logoutMenu);
    }

    public void doLogout() {

        //DriverManager.getDriver().findElement(logoutButton).click();
        click(WaitStrategy.CLICKABLE, logoutButton);
    }


}
