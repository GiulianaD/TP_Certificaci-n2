package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utilities.DriverManager;

public class LoginSteps {
    LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage(DriverManager.getDriver().driver);
    }

    @Given("I set the username text box with {string}")
    public void setUsernameTextBox(String username) {
        loginPage.setUsername(username);
    }

    @Given("I set the password text box with {string}")
    public void setPasswordTextBox(String password) {
        loginPage.setPassword(password);
    }

    @When("I click on the login button")
    public void clickOnLoginButton() {
        loginPage.clickLoginButton();
    }
}
