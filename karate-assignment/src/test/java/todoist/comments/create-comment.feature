@createComment
Feature: Create comment
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def taskId = testData.getTaskId()
    * def projectId = testData.getProjectId()

  Scenario: Add new comment to todoist
    Given path 'comments'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def content = "Need one bottle of milk"

    And request
      """
      {
        "task_id": '#(taskId)',
        "content": '#(content)',
        "content": "Need one bottle of milk",
        "attachment": {
          "resource_type": "file",
          "file_url": "https://s3.amazonaws.com/domorebetter/Todoist+Setup+Guide.pdf",
          "file_type": "application/pdf",
          "file_name": "File.pdf"
        }
      }
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setCommentId(response.id)
    * match response.content == content

  Scenario: Add new comment to without  request body
    Given path 'comments'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'

    When method post
    Then status 400





