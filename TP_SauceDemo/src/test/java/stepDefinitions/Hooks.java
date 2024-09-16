package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import utilities.DriverManager;

public class Hooks {
    @AfterAll
    public static void after_all() {
        DriverManager.getDriver().driver.quit();
    }
}
