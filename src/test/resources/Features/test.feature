Feature: To test create user functionality

  @Test1
  Scenario: Check user account is created successfully with valid information
    Given Create Account page is opened
    When I submit form with "John" and "Doe"
    Then "John Doe" account page is opened


  Scenario: Retrieve all pets with given status
    Given I Set POST service api endpoint
    When I submit GET request to get pets with status: "available"
    Then Status code: "200" is displayed
    And Response contains only nodes with status: "available"

  Scenario: Create new pet
    Given I Set POST service api endpoint
    When I submit POST request to create pet with name: "Zebra"
    Then Status code: "200" is displayed
    And Response contains node: "name" with value: "Zebra"

  Scenario: Update status of existing pet
    Given I Set POST service api endpoint
    And I submit PUT request to update existing pet with status: "sold"
    Then Status code: "200" is displayed
    And Response contains node: "status" with value: "sold"

  Scenario: Delete existing pet
    Given I Set POST service api endpoint
    And I submit DELETE request to delete existing pet
    Then Status code: "200" is displayed
    And Response contains message "Pet deleted"


