Feature: Visual
Description for visual tests

  @SeverityLevel.MINOR 
  Scenario: First UX test
	This is the description for this scenario.
    Given Login page is displayed
    Then validateScreenshot
    
	@SeverityLevel.CRITICALs
  @Issue("PPE-1000")
  @ManualTest
  Scenario: I want to validate that the home page is the same
    XXXXXXXXXXXXXXXXXXXXX
    Given: Login page is displayed
    Then: I should access to to home page
    And: Validate notifications are the same.
    