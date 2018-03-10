Feature: Ui Tests
This is the description for the feature

  @SeverityLevel.BLOCKER @Issue("JIRA-1") @Testcaseid("JIRA-642")
  Scenario: Login successful with UI
	This is the description for this scenario.
    Given Login page is displayed
    And Enter valid credentials
    Then Welcome page is displayed

