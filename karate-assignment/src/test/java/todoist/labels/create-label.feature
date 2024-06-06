@createLabel
Feature: Create comment
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def taskId = testData.getTaskId()
    * def projectId = testData.getProjectId()


  Scenario: Add new comment to todoist
    Given path 'labels'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def random = function() { return Math.floor(Math.random() * 10000); }
    * def name = 'food' + random()

    And request
      """
      {"name": '#(name)'}
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setLabelId(response.id)
    * match response.name == name


