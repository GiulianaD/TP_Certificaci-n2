Feature: Inventory Page
  Background:
    Given I am in Sauce Demo web page
    And I set the username text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The header should be displayed

  Scenario: Sort products by price in descending order
    When I sort the products by "Price (high to low)"
    Then The products should be displayed in descending order of price
