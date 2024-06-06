@createTask
Feature: Create task
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario: Add new task to todoist
    * def projectId = testData.getProjectId()
    Given path 'tasks'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def contentName = "Buy Milk"

    And request
      """
      {"content": '#(contentName)', "due_string": "tomorrow at 12:00", "due_lang": "en", "priority": 4}
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setTaskId(response.id)
    * match response.content == contentName
    * match response == "#object"



