Feature: Ui Tests
This is the description for the feature

  @SeverityLevel.BLOCKER 
  @Issue("http://www.google.com")
  Scenario: Login successful with UI
	This is the description for this scenario.
    Given Login page is displayed
    And Enter valid credentials
    Then Welcome page is displayed

