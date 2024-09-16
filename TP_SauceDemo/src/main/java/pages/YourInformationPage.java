package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourInformationPage {
    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameTextBox;
    @FindBy(id = "last-name")
    WebElement lastNameTextBox;
    @FindBy(id = "postal-code")
    WebElement zipCodeTextBox;
    @FindBy(id="continue")
    WebElement continueButton;
    @FindBy(className =  "title")
    WebElement title;
    String correctTitle;

    public YourInformationPage(WebDriver driver) {
        this.driver = driver;
        this.correctTitle = "Checkout: Your Information";
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTextBox(String firstName) {
        firstNameTextBox.sendKeys(firstName == null ? "" : firstName);
    }

    public void setLastNameTextBox(String lastName) {
        lastNameTextBox.sendKeys(lastName == null ? "" : lastName);
    }

    public void setZipCodeTextBox(String zipCode) {
        zipCodeTextBox.sendKeys(zipCode == null ? "" : zipCode);
    }

    public boolean verifyTitleText() {
        String actualTitle = title.getText();
        return actualTitle.equals(correctTitle);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public boolean verifyErrorMessageIsDisplayed() {
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("error-message-container")));
        return errorMessage.isDisplayed();
    }
}
