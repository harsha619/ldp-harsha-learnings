@getAllProjects
Feature: Get all the list of projects
  Background: Set URL
    * url BASE_URL

  Scenario: Check all the list of projects
    Given path 'projects'
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get

    Then status 200
    * match responseHeaders["Content-Type"] contains ["application/json"]

    * string jsonSchemaExpected = read("file:src/test/java/todoist/projects/schema/project.json")
    * string jsonData = response[0]
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)

