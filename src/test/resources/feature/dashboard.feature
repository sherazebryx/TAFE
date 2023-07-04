Feature: Course Search Functionality for TAFE Website

  Scenario: Course is available for on-site
    Given I am on the TAFE dashboard page
    Given Search for the course using search box
    When I click on the search button
    Then verify course appears
    When apply filter on campus
    Then verify filter is applied