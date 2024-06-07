Feature: Close task
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def taskId = testData.getTaskId()

  Scenario: Close the task by id
    Given path 'tasks/' + taskId + "/close"
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method post
    Then status 204




