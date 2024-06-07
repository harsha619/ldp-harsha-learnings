Feature: Delete task
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def taskId = testData.getTaskId()

  Scenario: Delete the task by id
    Given path 'tasks/' + taskId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method delete
    Then status 204




