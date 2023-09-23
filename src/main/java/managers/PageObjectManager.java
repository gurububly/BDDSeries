package managers;

import pageobjects.HRMHomePage;
import pageobjects.LoginPage;

public class PageObjectManager {

    static LoginPage loginPage;
    static HRMHomePage homePage;


    public static LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage() : loginPage;
    }

    public static HRMHomePage gethHomePage() {
        return (homePage == null) ? homePage = new HRMHomePage() : homePage;
    }
}
