package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import pageobjects.HRMHomePage;
import pageobjects.LoginPage;

public class LoginPageSteps {
    LoginPage loginPage;
    HRMHomePage homePage;

    @Given("When user is on the homepage")
    public void when_user_is_on_the_homepage() {
        System.out.println("user is on the homepage");
    }

    @When("user enters the username as {string} and password as {string}")
    public void user_enters_the_username_as_and_password_as(String string, String string2) {
        loginPage = PageObjectManager.getLoginPage();
        //LoginPage lp = new LoginPage();
        loginPage.enterUserName(string);
        loginPage.enterPassword(string2);
    }

    @Then("user clicked on login button")
    public void user_clicked_on_login_button() {
        // LoginPage lp = new LoginPage();
        loginPage.clickLogin();
    }

    @Then("user should be on the homepage")
    public void user_should_be_on_the_homepage() {
        //HRMHomePage hrmHomePge = new HRMHomePage();
        homePage = PageObjectManager.gethHomePage();
        String actualTitle = homePage.getHomePageTitle();
        System.out.println(actualTitle);
        homePage.selectLogoutMenu();
        homePage.doLogout();
    }

}
