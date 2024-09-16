package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SideMenuPage {
    WebDriver driver;

    @FindBy(id = "inventory_sidebar_link")
    WebElement inventorySidebarLink;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutSidebarLink;
    @FindBy(id =  "logout_sidebar_link")
    WebElement logoutSidebarLink;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetSidebarLink;

    public SideMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickInventorySidebarLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(inventorySidebarLink));
        inventorySidebarLink.click();
    }

    public void clickAboutSidebarLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(aboutSidebarLink));
        aboutSidebarLink.click();
    }

    public void clickLogoutSidebarLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(logoutSidebarLink));
        logoutSidebarLink.click();
    }

    public void clickResetSidebarLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(resetSidebarLink));
        resetSidebarLink.click();
    }

    public boolean verifySauceLabsWebPageIsOpened() {
        String expectedURL = "https://saucelabs.com/";
        return driver.getCurrentUrl().equals(expectedURL);
    }
}
