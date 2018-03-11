Feature: Api
Description for API tests

  @SeverityLevel.BLOCKER 
  @Issue("JIRA-1099")
  Scenario: /alert successful
	This is the description for this scenario.
    Given I create an alert
    When I send a request to alert
    Then The status code should be "201"
    And I should see all the alerts for the current user
    But Delete alerts created

  @SeverityLevel.BLOCKER 
  @Issue("JIRA-1099")
  @systemIsUnavailable
  Scenario: /alert when system is down
	This is the description for this scenario.
		Given System is unavailable
    When I send a request to alert
    Then The status code should be "503"
    And I should see an error message
    But System is available
