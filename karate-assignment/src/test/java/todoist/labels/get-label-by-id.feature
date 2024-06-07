@getLabelById
Feature: Get label by id
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def labelId = testData.getLabelId()

  Scenario: Check response by  label id
    Given path 'labels/' + labelId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * match response.id == labelId
    * match response == "#object"