Feature: Team information back end


  Scenario: Team members db test
    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    When the user goes to the "my team" page
    Then team information should match database records

  @db

  Scenario: Verify rooms and clusters
    Given  there is a list of clusters in the clusters table
    And all rooms have a clusters id in room table
    Then all the clusters ids must be from the clusters table

  @db
  Scenario: Verify user information per database

    Given user on the login page
    When user logs in using "mstacey8r@imdb.com" and "skylargiblin"
    When the user goes to the "my team" page
    Then correct user information should be displayed for "mstacey8r@imdb.com"



    # in this test we are getting the user information from database
  # We wrote a query that pulls information of a different user from db every time we run the test

  @wip @db
  Scenario: Verify any user login
      Given user on the login page
      When user logs in any user
      Then homepage should be displayed