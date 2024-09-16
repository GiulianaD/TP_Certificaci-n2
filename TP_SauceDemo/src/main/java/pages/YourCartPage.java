package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {
    WebDriver driver;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(className =  "title")
    WebElement title;
    String correctTitle;

    public YourCartPage(WebDriver driver) {
        this.driver = driver;
        this.correctTitle = "Your Cart";
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean verifyTitleText() {
        String actualTitle = title.getText();
        return actualTitle.equals(correctTitle);
    }
}
