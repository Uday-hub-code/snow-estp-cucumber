Feature: Login Tests
This is the description for the feature

  @SeverityLevel.BLOCKER @Issue("JIRA-1") @Testcaseid("JIRA-642")
  Scenario: Login successful
	This is the description for this scenario.
    Given Login page is displayed
    And Enter valid credentials
    Then Welcome page is displayed

	@SeverityLevel.NORMAL
	@Issue("JIRA-1")
  Scenario: Wrong username
	This is the description for this scenario
    Given Login page is displayed
    And Enter invalid username and valid password
    Then Wrong user message is displayed
    
	@SeverityLevel.CRITICAL
  @link("https://cucumber.io/docs/reference/jvm")
  Scenario: Wrong password
	This is the description for this scenario
    Given Login page is displayed
    And Enter valid username and invalid password
    Then Wrong password message is displayed
