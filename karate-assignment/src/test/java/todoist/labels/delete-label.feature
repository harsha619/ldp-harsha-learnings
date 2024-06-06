Feature: Delete label
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def labelId = testData.getLabelId()

  Scenario: Delete the label by id
    Given path 'labels/' + labelId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method delete
    Then status 204




