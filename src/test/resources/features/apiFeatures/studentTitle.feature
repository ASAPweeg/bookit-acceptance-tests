Feature: Student Title API Automation Testing


  @studentTitle
  Scenario: Student Title Validation

    When user hits all student API "http://cybertekchicago.com/student/all"
    Then user tests the titles




    @studentEmail
    Scenario: Stdeunt email verification
      When user hits all student API "http://cybertekchicago.com/student/all"
      Then user verifies each students email address to be valid