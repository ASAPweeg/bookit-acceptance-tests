Feature: room information functionality

  @wip
  Scenario: Room details
    Given user on the login page
    When user logs in using "daldie7l@seattletimes.com" and "ruthannjohnes"
    Then correct room information should be displayed for light side

#    And room information should be displayed as given in "file_path" "sheetname"