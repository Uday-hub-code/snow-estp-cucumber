Feature: Visual
Description for visual tests

  @Visual
  Scenario: Login
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validateScreenshot

  @Visual
  Scenario: Login Excluding Video Section
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validateScreenshot excluding video section

  @Visual
  Scenario: Login Validate Logo Button
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validate logo button
