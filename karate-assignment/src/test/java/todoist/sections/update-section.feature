@updateSection
Feature: Update section
  Background: Set URL
    * url BASE_URL
    * def testData = Java.type('todoist.utils.TestData')

  Scenario:  Check name of updated section
    * def projectId = testData.getProjectId()
    * def sectionId = testData.getSectionId()
    Given path 'sections/' + sectionId
    And header Authorization = 'Bearer ' + ACCESS_TOKEN
    And header Content-Type = 'application/json'
    * def name = "updated Groceries"

    And request
      """
      { "name":'#(name)'}
      """
    When method post
    Then status 200

    * match responseHeaders["Content-Type"] contains ["application/json"]
    * match response.name == name

    * string jsonSchemaExpected = read("file:src/test/java/todoist/sections/schema/section.json")
    * string jsonData = response
    * print 'jsonData:', jsonData
    * def SchemaUtils = Java.type("todoist.utils.JSONSchemaUtil")
    * assert SchemaUtils.isValid(jsonData,jsonSchemaExpected)
  #    * def result = call read('delete-section.feature')



