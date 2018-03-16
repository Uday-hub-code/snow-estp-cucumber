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
    Then validateScreenshot
