Feature: Hris Detail extraction Automation feature
 
Scenario: Hris Scenario
    Given Hris Login Page
    When user name and password is Entered 
    Then click on Login Button
    Then check on timesheet page by title
    Then Get detail of Employee in Text file 
    Then Mail the Detail of the Text file
    And click on backlog create task
   