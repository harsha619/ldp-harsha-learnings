@updateProject
Feature: Update project
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario: Check name of updated project
    * def projectId = testData.getProjectId()
    Given path 'projects/' + projectId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def name = "updated Shopping List"

    And request
      """
      {"name" : "#(name)" }
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * match response.name == name

    * string jsonSchemaExpected = read("file:src/test/java/todoist/projects/schema/project.json")
    * string jsonData = response
    * print 'jsonData:', jsonData
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)
  #    * def result = call read('get-project.feature')



