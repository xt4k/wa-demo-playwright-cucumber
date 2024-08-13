Feature: Efbet betslip functionality:
  Check that unregistered user cannot place bet.

  Scenario: Check that unregistered user cannot place bet.
    Given user navigated to homepage
    When user select tab "Sports"
    And user select "Popular Competitions" list item in left menu
    And user select top row from list
    And user select first match from prematch page block
    Then in betslip block present notification "To place your bet, please Sign in orRegister"
