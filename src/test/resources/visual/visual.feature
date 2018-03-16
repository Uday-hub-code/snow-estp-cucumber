Feature: Visual
Description for visual tests

  @Visual
  Scenario: Login
	This is the description for this scenario.
    Given Login page is displayed
    When Welcome page is displayed
    Then validateScreenshot

  @Visual
  Scenario: Login
	test that pass.
    Given Login page is displayed
    When Welcome page is displayed
    Then testPasses

  @Visual
  Scenario: Login
	test that pass.
    Given Login page is displayed
    When Welcome page is displayed
    Then testDontPass
