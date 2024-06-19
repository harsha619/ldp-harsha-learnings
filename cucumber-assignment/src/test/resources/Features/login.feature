Feature: Searching items for products in amazon

  Background: User is in amazon page

  Scenario:verify login process
    When User Click on login
    And User enter email address
    And User click on continue
    And User enter valid password
    And User click on Signin
    Then verify the home page

  Scenario: Navigate to mobiles
    When  User will navigate to navbar
    And User click on mobiles
    And User will click on mobiles section
    And User click on prime checkBox
    Then  verify the mobiles on first page

  Scenario:  Verify the last year order
    When User click on my orders
    And Select last year orders
    Then verify the last year orders

  Scenario: Add new payments
    When User click on my account
    And User click on my payments
    Then Verify payment details

  Scenario: Add new address
    When User click on my account
    And User click on your addresses
    And User click on add address
    And User enter valid full name
    And User enter valid mobile number
    And User enter valid pineCode
    And User enter valid area address
    And User click on submit address
    Then Verify added address



