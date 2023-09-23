Feature: Verifying the hrm login functionality
  Scenario: validating the hrm login with valid credentials
    Given When user is on the homepage
    When user enters the username as "Admin" and password as "admin123"
    Then user clicked on login button
    Then user should be on the homepage

