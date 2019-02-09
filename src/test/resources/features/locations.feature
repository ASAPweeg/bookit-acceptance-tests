Feature: campus locations

  Scenario: VA - dark side
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    Then location should be "dark-side"

  Scenario: VA - light side
    Given user on the login page
    When user logs in using "ucharlot7y@nbcnews.com" and "archibaldmelloy"
    Then location should be "light-side"

  Scenario: Illinois
    Given user on the login page
    When user logs in using "fbawmeb7@studiopress.com" and "sherilyngohn"
    Then location should be "il"