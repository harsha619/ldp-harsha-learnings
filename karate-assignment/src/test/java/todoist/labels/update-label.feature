@updateSection
Feature: Update label
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario:  Check name of updated comment
    * def labelId = testData.getLabelId()
    Given path 'labels/' + labelId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def random = function() { return Math.floor(Math.random() * 10000); }
    * def name = 'drinks' + random()

    And request
      """
      {"name": '#(name)'  }
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setLabelId(response.id)
    * match response.name == name
    * match response == "#object"