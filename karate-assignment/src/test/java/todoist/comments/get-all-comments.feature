@allComments
Feature: Get all the list of comments
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def taskId = testData.getTaskId()

  Scenario: Check all the list of comments
    Given path 'comments'
    And param task_id = taskId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * match response[0] == "#object"
