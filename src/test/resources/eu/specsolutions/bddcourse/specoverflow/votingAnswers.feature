Feature: Voting Answers

  Rule: Only authenticated users can vote

      @login
      Scenario: Only the authenticated user can vote the answers
        Given the user is logged in
        When the user gives vote for an answer
        Then vote is successfully counted for that answer