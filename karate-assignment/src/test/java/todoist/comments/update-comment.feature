@updateComment
Feature: Update commnet
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario:  Check name of updated comment
    * def commentId = testData.getCommentId()
    Given path 'comments/' + commentId
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
    * match response.content == contentName
