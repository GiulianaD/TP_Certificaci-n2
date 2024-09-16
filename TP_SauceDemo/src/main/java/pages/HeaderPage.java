package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderPage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement sauceDemoTitle;
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;
    @FindBy(className = "bm-burger-button")
    WebElement sideMenuIcon;

    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean sauceDemoTitleIsDisplayed() {
        return sauceDemoTitle.isDisplayed();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public void clickSideMenuIcon() {
        sideMenuIcon.click();
    }

    public boolean compareCartIconNumber(String cartNumber) {
        String actualCartNumber = cartIcon.getText();
        return actualCartNumber.equalsIgnoreCase(cartNumber);
    }
}
