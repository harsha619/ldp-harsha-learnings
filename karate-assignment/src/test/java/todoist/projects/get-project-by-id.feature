@getProjectById
Feature: Get  project
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def projectId = testData.getProjectId()
    * print projectId

  Scenario: Check project response by id
    Given path 'projects/' + projectId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get
    Then status 200
    * match responseHeaders["Content-Type"] contains ["application/json"]
    * print response
    * match response.id == projectId


    * string jsonSchemaExpected = read("file:src/test/java/todoist/projects/schema/project.json")
    * string jsonData = response
    * print 'jsonData:', jsonData
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)



