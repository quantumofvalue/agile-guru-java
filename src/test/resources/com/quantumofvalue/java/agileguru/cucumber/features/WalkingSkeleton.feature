Feature: Walking skeleton
    As a developer
    I want to deliver a simple functionality that triggers initial architectural discussion and drives creating the testing infrastructure
    so that I can start development in a sustainable pace.

Scenario: Retrieving items from the database
    Given items "Test Item 0" and "Test Item 1" in the database
    When I open "items" page
    Then I should see "Test Item 0" and "Test Item 1" listed on the page.