Feature: Login Sauce Demo App
  Background:
    Given I am in Sauce Demo web page

  Scenario: Login into Sauce Demo with valid credentials
    Given I set the username text box with "standard_user"
    And I set the password text box with "secret_sauce"
    When I click on the login button
    Then The header should be displayed