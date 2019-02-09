Feature: My details page


  Scenario: my information
    Given user on the login page
    And user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    When the user goes to the "my self" page
    Then the user should see their information:
      | name   | Ruthann Johnes      |
      | role   | student-team-leader |
      | team   | CodeHunters         |
      | batch  | #8                  |
      | campus | VA                  |

    # BREAK 3.15 pm est



  @wip
  Scenario: room information
    Given user on the login page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then user should be able to see quotes info for each room
      | ping pong | the more the better |
