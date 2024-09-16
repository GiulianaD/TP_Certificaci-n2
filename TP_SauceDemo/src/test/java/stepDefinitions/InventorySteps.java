package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.InventoryPage;
import utilities.DriverManager;

public class InventorySteps {
    InventoryPage inventoryPage;

    public InventorySteps() {
        inventoryPage = new InventoryPage(DriverManager.getDriver().driver);
    }

    @Then("All the product buttons should have the text {string}")
    public void checkButtonsText(String text) {
        Assertions.assertTrue(inventoryPage.compareAllButtonsText(text));
    }

    @Given("I add to the cart the product {string}")
    public void addProductToCart(String product) {
        inventoryPage.addProductToCart(product);
    }

    @When("I sort the products by {string}")
    public void sortProductsBy(String orderBy) {
        inventoryPage.sortProductsBy(orderBy);
    }

    @Then("The products should be displayed in descending order of price")
    public void verifyProductsDisplayedInDescendingOrderOfPrice() {
        Assertions.assertTrue(inventoryPage.verifyProductsInDescendingPriceOrder());
    }
}
