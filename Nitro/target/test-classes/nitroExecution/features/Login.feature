Feature: Login
  user login into application

  
  Scenario: Successful login
    Given user in the login page
    And user input valid credentials
    Then user sucessfully login into the application