Feature: Registration

  Rule: Registration data should be valid

    The registration data that is the username and password should be valid.
    The password and Re-enter password should match.



      Scenario: User registers successfully with valid data
        Given the user clicks register button
        And populate username "Marvin" and password "1234"
        And Re-enter password "1234"
        When the user submits the registration
        Then the user is registered successfully