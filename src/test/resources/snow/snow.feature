Feature: Snow
Description for Snow tests

  @SeverityLevel.NORMAL
  @ignore
  Scenario: Features
	This is the description for this scenario.
    Given Login page is displayed
    And Enter valid credentials
    Then I go to snow

  @SeverityLevel.NORMAL
  Scenario: Configs
	This is the description for this scenario.
    Given Login page is displayed
    And Enter valid credentials
    Then Welcome page is displayed
    But I should see an error here
