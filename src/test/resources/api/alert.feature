Feature: Api
Description for API tests

  @SeverityLevel.BLOCKER 
  @Issue("JIRA-1")
  Scenario: /alert {GET}
	This is the description for this scenario.
    Given I send a request to alert
    Then I should see all the alerts for the current user
