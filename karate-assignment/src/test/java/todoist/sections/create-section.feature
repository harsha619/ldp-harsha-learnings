@createSection
Feature: Create section
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario: Add new section to todoist
    * def projectId = testData.getProjectId()
    Given path 'sections'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def name = "Groceries"

    And request
      """
      {"project_id":'#(projectId)', "name":"Groceries"}
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * testData.setSectionId(response.id)
    * match response.name == name

    * string jsonSchemaExpected = read("file:src/test/java/todoist/sections/schema/section.json")
    * string jsonData = response
    * print 'jsonData:', jsonData
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)
