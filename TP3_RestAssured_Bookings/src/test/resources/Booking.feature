Feature: Booking Endpoints in RestfulBooker API
  Background: Booking endpoints should manage bookings, allowing clients to retrieve, create, update and delete booking records
# GET TESTS

  Scenario: Get a booking by an existing id
    Given I send a GET request to the booking endpoint with the id "1"
    Then I should get a 200 response
    And The response should contain all booking fields

  Scenario: Get a booking by a non existing id
    Given I send a GET request to the booking endpoint with the id "wrong"
    Then I should get a 404 response

# POST TEST
  Scenario:  Create a new booking with valid data
    Given I have the following data to create a new booking
      | 2024-01-01 | 2024-01-05 | Marcos | Campero | true | 456 |breakfast  |
    When I send a POST request to the booking endpoint with the payload
    Then I should get a 200 response

  Scenario Outline:  Create a new booking with incomplete data
    Given I have the following data to create a new booking
      | <checkin_date> | <checkout_date> | <firstname> | <lastname> | <deposit_paid> | <total_price> |  <additional_needs> |
    When I send a POST request to the booking endpoint with the payload
    Then I should get a 400 response
    Examples:
      | checkin_date | checkout_date | firstname | lastname | deposit_paid | total_price | additional_needs |
      | 2024-01-01   | 2024-01-05    |           | Campero  | true         | 456         | breakfast        |
      | 2024-01-01   |               | Marcos    | Campero  | true         | 456         | breakfast        |
      | 2024-01-01   | 2024-01-05    | Marcos    | Campero  |              | 456         | breakfast        |
      | 2024-01-01   | 2024-01-05    | Marcos    | Campero  | true         |             | breakfast        |

  Scenario Outline: Create a new booking with invalid data
    Given I have the following data to create a new booking with invalid data types
      | <checkin_date> | <checkout_date> | <firstname> | <lastname> | <deposit_paid> | <total_price> | <additional_needs> |
    When I send a POST request to the booking endpoint with the payload
    Then I should get a 400 response
    Examples:
      | checkin_date | checkout_date | firstname | lastname | deposit_paid | total_price | additional_needs |
      | 2024-01-01   | 2024-01-05    | Marcos    | Campero  | 156          | true        | breakfast        |