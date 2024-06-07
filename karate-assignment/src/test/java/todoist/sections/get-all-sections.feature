@getAllSections
Feature: Get all the list of sections
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario: Check all the list of sections
    Given path 'sections'
    And params project_id = testData.getProjectId()
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    When method get

    Then status 200
    * match responseHeaders["Content-Type"] contains ["application/json"]

    * string jsonSchemaExpected = read("file:src/test/java/todoist/sections/schema/section.json")
    * def responseLength = response.length

    * def responseGreaterThanOne =
      """
      function(response, jsonSchemaExpected) {
        var jsonData = response[0];
        karate.log('jsonData:', jsonData);
        var jsonString = JSON.stringify(jsonData);
        var SchemaUtils = Java.type('todoist.utils.JSONSchemaUtil');
        if (!SchemaUtils.isValid(jsonString, jsonSchemaExpected)) {
          return karate.fail("Section schema is not validated")
        }
        return true
      }
      """

    * print response.length
    * if (response.length > 0)  var schemaValid = responseGreaterThanOne(response, jsonSchemaExpected)