package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.YourCartPage;
import utilities.DriverManager;

public class YourCartSteps {
    YourCartPage yourCartPage;

    public YourCartSteps() {
        yourCartPage = new YourCartPage(DriverManager.getDriver().driver);
    }

    @And("I click on the checkout button")
    public void clickOnCheckoutButton() {
        yourCartPage.clickCheckoutButton();
    }

    @Then("Your Cart Page should be displayed")
    public void verifyYourCartPageIsDisplayed(){
        Assertions.assertTrue(yourCartPage.verifyTitleText());
    }
}
