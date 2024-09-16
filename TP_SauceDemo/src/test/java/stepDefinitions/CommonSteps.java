package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverManager;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonSteps {
    WebDriver driver;

    public CommonSteps() {
        this.driver = DriverManager.getDriver().driver;
    }
    @Given("I am in Sauce Demo web page")
    public void goToSauceDemoWebPage() {
        this.driver.get("https://saucedemo.com");
        this.driver.manage().window().maximize();
    }

    @Then("A new tab should open")
    public void verifyNewTabOpened() {
        try {
            int previousNumberOfTabs = DriverManager.getDriver().numberOfTabs;
            new WebDriverWait(this.driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfWindowsToBe(previousNumberOfTabs + 1));

            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            this.driver.switchTo().window(tabs.get(1));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("The new page URL should be {string}")
    public void verifyNewPageURL(String pageURL) {
        Assertions.assertEquals(driver.getCurrentUrl(), pageURL);
    }
}
