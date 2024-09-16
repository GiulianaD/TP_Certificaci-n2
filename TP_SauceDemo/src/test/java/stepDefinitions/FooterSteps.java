package stepDefinitions;

import io.cucumber.java.en.When;
import pages.FooterPage;
import utilities.DriverManager;

public class FooterSteps {
    FooterPage footerPage;

    public FooterSteps() {
        footerPage = new FooterPage(DriverManager.getDriver().driver);
    }

    @When("I click on the Facebook link")
    public void clickOnFacebookLink() {
        DriverManager.saveNumberWindows();
        footerPage.clickOnFacebookLink();
    }
}
