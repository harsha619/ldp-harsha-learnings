Feature: Delete  projects
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def projectId = testData.getProjectId()
    * print projectId

  Scenario: Check the section deletion by id
    Given path 'projects/' + projectId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def name = "Shopping List"
    When method delete
    Then status 204



