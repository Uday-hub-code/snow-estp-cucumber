Feature: Visual
Description for visual tests

  @SeverityLevel.MINOR 
  Scenario: First UX test
	This is the description for this scenario.
    Given Login page is displayed
    Then validateScreenshot
    
	@SeverityLevel.CRITICAL
  @Issue("PPE-1000")
  @manual_test
  Scenario: I want to validate that the home page is the same
    This is the description for sscenario
    Given: Login page is displayed
    Then: I should access to to home page
    And: Validate notifications are the same.
    