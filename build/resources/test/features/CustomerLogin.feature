Feature: Customer Login
  This test suite contains simple test cases for validating the Customer Login use case.
  Created By: Arun Kumar
  Version: 1.0

  Background:
    Given a customer launches browser and enters url "https://www.browserstack.com/"
    And a customer clicks the Sign-in Button

  Scenario Outline: Customer Login with Valid credentials
    Given a customer is on the Login Page
    And   Enters valid <username> and <password>
    When  Customer clicks the Sign-in Button
    Then  Customer should login to the home page

    Examples:
      | username                 | password    |
      | "bkumar202120@gmail.com" | "bkumar@2021" |


  Scenario: Customer Login with Invalid Credentials
    Given a customer is on the Login Page
    And   Enter invalid "username@gmail.com" and "password"
    When  Customer clicks the Sign-in Button
    Then  Customer should not login to the home page
    And   Login page should display message "Invalid password"






