package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.SideMenuPage;
import utilities.DriverManager;

public class SideMenuSteps {

    SideMenuPage sideMenuPage ;

    public SideMenuSteps() {
        this.sideMenuPage = new SideMenuPage(DriverManager.getDriver().driver);
    }

    @And("I click on the about link")
    public void clickOnAboutLink() {
        sideMenuPage.clickAboutSidebarLink();
    }

    @And("I click on the reset app link")
    public void clickOnResetAppLink()
    {
        sideMenuPage.clickResetSidebarLink();
    }

    @Then("The Sauce Labs web page should be opened")
    public void verifySauceLabsWebPageIsOpened() {
        Assertions.assertTrue(sideMenuPage.verifySauceLabsWebPageIsOpened());
    }
}
