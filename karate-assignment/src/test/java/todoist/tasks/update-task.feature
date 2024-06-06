@updateSection
Feature: Update section
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario:  Check name of updated section
    * def taskId = testData.getTaskId()
    Given path 'tasks/' + taskId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def contentName = "Updated Buy Milk"

    And request
      """
      {"content": '#(contentName)'}
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setTaskId(response.id)
    * match response.content == contentName
    * match response == "#object"
  #    * def result = call read('section-by-id.feature')



