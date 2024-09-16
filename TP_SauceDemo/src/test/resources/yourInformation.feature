Feature: Checkout Your Information Page
  Background:
    Given I am in Sauce Demo web page
    And I set the username text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The header should be displayed
    And I click on the cart icon
    Then Your Cart Page should be displayed
    And I click on the checkout button
    Then Checkout Your Information Page should be displayed

  Scenario Outline: Send invalid firstname for checkout information
    When I fill the checkout information
      | <firstname> | <lastname> | <zip code> |
    And I click on the continue button
    Then An error message should be displayed
    Examples:
      | firstname | lastname | zip code |
      |           | Valdez   | 000      |
      | Juan      |          | 000      |
      | Juan      | Valdez   |          |