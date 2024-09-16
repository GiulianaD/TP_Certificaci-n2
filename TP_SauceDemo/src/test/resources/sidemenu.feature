Feature: Sauce Demo Side Menu
  Background:
    Given I am in Sauce Demo web page
    When I set the username text box with "standard_user"
    And I set the password text box with "secret_sauce"
    And I click on the login button
    Then The header should be displayed


  Scenario:  Click on the About Link
    When I open the side menu
    And I click on the about link
    Then The Sauce Labs web page should be opened

  Scenario Outline: Click on the Reset App Link
    Given I add to the cart the product "<products>"
    When I open the side menu
    And I click on the reset app link
    Then The cart icon should not have any number
    And All the product buttons should have the text "Add to cart"
    Examples:
      | products                 |
      | Sauce Labs Backpack      |
      | Sauce Labs Bike Light    |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |