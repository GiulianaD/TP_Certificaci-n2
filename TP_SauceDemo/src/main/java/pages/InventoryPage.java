package pages;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {
    WebDriver driver;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productsNames;
    @FindBy(className = "btn_inventory")
    List<WebElement> productsButtons;
    @FindBy(className = "product_sort_container")
    WebElement sortingFilter;
    @FindBy(className = "inventory_item_price")
    List<WebElement> productsPrices;

    Select selectSortingFilter;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        selectSortingFilter = new Select(this.sortingFilter);
    }

    public boolean compareAllButtonsText(String text) {
        for (WebElement button : productsButtons) {
            String actualText = button.getText();
            if (!button.getText().equals(text)) {
                return false;
            }
        }

        return true;
    }

    public boolean verifyButtonTextByProduct(String text) {
        String buttonId = "add-to-cart-" + text.replace(" ", "-").toLowerCase();
        WebElement productButton = driver.findElement(By.id(buttonId));
        return productButton.getText().equals(text);
    }

    public void addProductToCart(String productName) {
        String productId = "add-to-cart-" + productName.replace(" ", "-").toLowerCase();
        WebElement productAddToCartButton = driver.findElement(By.id(productId));
        productAddToCartButton.click();
    }

    public void sortProductsBy(String orderBy){
        selectSortingFilter.selectByVisibleText(orderBy);
    }

    public boolean verifyProductsInDescendingPriceOrder(){
        List<Float> actualPrices = new ArrayList<>();

        for(WebElement price : productsPrices) {
            Float numericPrice = Float.parseFloat(price.getText().replaceFirst("\\$", ""));
            actualPrices.add(numericPrice);
        }

        return  Ordering.natural().reverse().isOrdered(actualPrices);
    }
}
