Feature: Home

Rule: The customer's username should be shown on home page when the user is logged in successfully

  Scenario: The username of logged in user is shown on home page
    Given the user is logged in
    When the user checks the home page
    Then the username is shown on home page