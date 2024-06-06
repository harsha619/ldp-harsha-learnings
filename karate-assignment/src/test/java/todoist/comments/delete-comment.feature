Feature: Delete comment
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def commentId = testData.getCommentId()

  Scenario: Delete the task by id
    Given path 'comments/' + commentId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method delete
    Then status 204




