Feature: User Login
  User login to the registered portal
  
 
  Scenario Outline: Verify that registired user login to respective portal with valid credentials
    Given user is in the login page
    When user enter the valid username <username>
    And click on Continue button
    And enter the valid password <password>
    And click on Continueo button
    Then user should lands on the Dashboard page
    Examples:
    |username             |password  |
    |swathi@divum.in      |Test@12345|
    |kmddorg084@tormails.com|Test@12345|
   
 