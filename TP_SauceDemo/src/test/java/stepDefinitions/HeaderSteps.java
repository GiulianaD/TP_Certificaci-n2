package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HeaderPage;
import utilities.DriverManager;

public class HeaderSteps {
    HeaderPage headerPage;

    public HeaderSteps() {
        this.headerPage = new HeaderPage(DriverManager.getDriver().driver);
    }

    @Then("The header should be displayed")
    public void verifyHeaderIsDisplayed() {
        Assertions.assertTrue(headerPage.sauceDemoTitleIsDisplayed());
    }

    @When("I open the side menu")
    public void openSideMenu() {
        headerPage.clickSideMenuIcon();
    }

    @Then("The cart icon should not have any number")
    public void verifyNumberOfCartIconIsNotDisplayed() {
        headerPage.compareCartIconNumber("");
    }

    @And("I click on the cart icon")
    public void clickCartIcon() {
        headerPage.clickCartIcon();
    }
}
