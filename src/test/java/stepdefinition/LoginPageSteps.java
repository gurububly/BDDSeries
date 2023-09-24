package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.PageObjectManager;
import org.testng.Assert;
import pageobjects.HRMHomePage;
import pageobjects.LoginPage;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

public class LoginPageSteps {
    LoginPage loginPage;
    HRMHomePage homePage;

    @Given("When user is on the loginpage")
    public void when_user_is_on_the_loginpage() {
        System.out.println("User is on the login page");
    }

    @When("user enters the username as {string} and password as {string}")
    public void user_enters_the_username_as_and_password_as(String string, String string2) {
        List<Map<String, String>> fullList = ExcelUtils.getTestData("Data");
        loginPage = PageObjectManager.getLoginPage();
        //LoginPage lp = new LoginPage();
        loginPage.enterUserName(fullList.get(1).get("username"));
        loginPage.enterPassword(fullList.get(1).get("password"));
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

    @When("user enters the username and password from the sheet {string} and rownumber {string}")
    public void user_enters_the_username_and_password_from_the_sheet_and_rownumber(String sheetname, String rownum) {
        List<Map<String, String>> fullList = ExcelUtils.getTestData("Data");
        loginPage = PageObjectManager.getLoginPage();
        loginPage.enterUserName(fullList.get(Integer.parseInt(rownum)).get("username"));
        loginPage.enterPassword(fullList.get(Integer.parseInt(rownum)).get("password"));
    }


    @When("user enters the username and password from the sheet as {string} and rownumber as {string}")
    public void user_enters_the_username_and_password_from_the_sheet_as_and_rownumber_as(String sheetname, String rownum) {
        List<Map<String, String>> fullList = ExcelUtils.getTestData("Sheet1");
        loginPage = PageObjectManager.getLoginPage();
        loginPage.enterUserName(fullList.get(Integer.parseInt(rownum)).get("username"));
        loginPage.enterPassword(fullList.get(Integer.parseInt(rownum)).get("password"));
    }

    @Then("user should see the message as {string}")
    public void user_should_see_the_message_as(String expectedText) {
        loginPage = PageObjectManager.getLoginPage();
        String acutalText = loginPage.getLoginErrorMessage();
        System.out.println("Acutal Result is::"+acutalText);
        Assert.assertEquals(acutalText, expectedText);
    }


}
