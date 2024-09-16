package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {
    WebDriver driver;
    @FindBy(css = "a[data-test='social-facebook']")
    WebElement facebookLink;
    @FindBy(css = "a[data-test='social-facebook']")
    WebElement twitterLink;
    @FindBy(css = "a[data-test='social-facebook']")
    WebElement linkedInLink;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFacebookLink() {
        facebookLink.click();
    }

    public void clickOnTwitterLink() {
        twitterLink.click();
    }

    public void clickOnLinkedInLink() {
        linkedInLink.click();
    }
}
