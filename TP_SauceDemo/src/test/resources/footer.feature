Feature: Sauce Demo Footer
  Background:
    Given I am in Sauce Demo web page
    And I set the username text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The header should be displayed

  Scenario:  Verify that the Facebook link opens the Sauce Labs Facebook Page
    When I click on the Facebook link
    Then A new tab should open
    And The new page URL should be "https://www.facebook.com/saucelabs"