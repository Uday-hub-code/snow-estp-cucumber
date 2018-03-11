Feature: Api
Description for API tests

  @SeverityLevel.BLOCKER 
  @Issue("JIRA-1099")
  Scenario: /alert successful
	This is the description for this scenario.
    Given I send a request to alert
    Then The status code should be "200"
    And I should see all the alerts for the current user

  @SeverityLevel.BLOCKER 
  @Issue("JIRA-1099")
  @tag1
  Scenario: /alert when system is down
	This is the description for this scenario.
		Given System is unavailable
    And I send a request to alert
    Then The status code should be "503"
    And I should see all the alerts for the current user
    
