Feature: Delete project
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def sectionId = testData.getSectionId()

  Scenario: Check the section deletion by id 
    Given path 'sections/' + sectionId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method delete
    Then status 204




