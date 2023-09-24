Feature: Verifying the hrm login functionality

  Scenario: validating the hrm login with valid credentials
    Given When user is on the loginpage
    When user enters the username as "Admin" and password as "admin123"
    Then user clicked on login button
    Then user should be on the homepage


  Scenario Outline: validating the hrm login with valid user details with multiple data set

    Given When user is on the loginpage
    When user enters the username and password from the sheet "<sheetname>" and rownumber "<rowNumber>"
    Then user clicked on login button
    Then user should be on the homepage
    Examples:
      | sheetname | rowNumber |
      | Data      | 0         |
      | Data      | 1         |
      | Data      | 2         |

  Scenario Outline: validating the hrm login with invalid credentials

    Given When user is on the loginpage
    When user enters the username and password from the sheet as "<sheetname>" and rownumber as "<rowNumber>"
    Then user clicked on login button
    Then user should see the message as "Invalid credentials"
    Examples:
      | sheetname | rowNumber |
      | Sheet1    | 0         |
      | Sheet1    | 1         |
