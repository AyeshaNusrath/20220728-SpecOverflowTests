Feature: AskingQuestions

  Rule: Similar questions to the one being asked are suggested
      @login
      Scenario: Suggestion appear successfully for the question being asked
        Given the user is on Ask Question page
        When the user start entering the title "What is"
        Then the suggestions are shown in 'Similar questions' section


  Rule: Only authenticated users can ask the questions

      @login
      Scenario: Only the successfully logged in user can ask question
        Given the user entered the question
        When the user clicks on 'Post your question' button
        Then the question is submitted
