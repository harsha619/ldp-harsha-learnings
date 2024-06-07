@getSectionById
Feature: Get section by id
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')
    * def sectionId = testData.getSectionId()

  Scenario: Check section  response bu id
    Given path 'sections/' + sectionId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get

    Then status 200
    * match responseHeaders["Content-Type"] contains ["application/json"]

    * string jsonSchemaExpected = read("file:src/test/java/todoist/sections/schema/section.json")
    * string jsonData = response
    * print 'jsonData:', jsonData
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)