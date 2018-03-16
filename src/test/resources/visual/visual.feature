Feature: Visual
Description for visual tests

  @Visual
  Scenario: Login
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validateScreenshot

  @Visual
  Scenario: Login_noVideo
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validateScreenshot excluding video

  @Visual
  Scenario: Login_logoButton
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validate logo button
