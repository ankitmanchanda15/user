Feature: User Registration

  Scenario: Successful user registration
    Given I am on the registration page
    When I fill in the registration form with valid details
      | firstName | lastName | email            | password  | phoneNumber |
      | John      | Doe      | john.doe@test.com| Password123| 1234567890  |
    And I submit the form
    Then I should see a success message
    And the user should be created in the service layer

  Scenario: Unsuccessful user registration with existing email
    Given I am on the registration page
    When I fill in the registration form with an existing email
      | firstName | lastName | email            | password  | phoneNumber |
      | Jane      | Smith    | john.doe@test.com| Password123| 0987654321  |
    And I submit the form
    Then I should see an error message