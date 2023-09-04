Feature: Check specific login functionality

  Scenario: Verify that user able to login with valid user name and password in nopStation
    Given Go to home page
    When User input email and password in login page
    And Click login button
    Then verify that user login successfully