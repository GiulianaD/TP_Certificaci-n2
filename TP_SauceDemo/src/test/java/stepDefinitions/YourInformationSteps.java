package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.YourInformationPage;
import utilities.DriverManager;

import java.util.List;

public class YourInformationSteps {
    YourInformationPage yourInformationPage;

    public YourInformationSteps() {
        yourInformationPage = new YourInformationPage(DriverManager.getDriver().driver);
    }

    @Then("Checkout Your Information Page should be displayed")
    public void verifyYourInformationPageIsDisplayed() {
        Assertions.assertTrue(yourInformationPage.verifyTitleText());
    }

    @And("I fill the checkout information")
    public void fillCheckoutInformation(DataTable checkoutInformation){
        List<String> data = checkoutInformation.transpose().asList(String.class);
        yourInformationPage.setFirstNameTextBox(data.get(0));
        yourInformationPage.setLastNameTextBox(data.get(1));
        yourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinueButton() {
        yourInformationPage.clickContinueButton();
    }

    @Then("An error message should be displayed")
    public void verifyErrorMessageIsDisplayed() {
        Assertions.assertTrue(yourInformationPage.verifyErrorMessageIsDisplayed());
    }
}
