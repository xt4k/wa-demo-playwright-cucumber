Feature: Live casino functionality:
  Check that signed player can play in defined live casino.

  Scenario Outline: Check that can play in defined live casino.
    Given user navigated to homepage
    When user select tab "Live casino"
    And user click `Games search` button
    And user search "<casinoName>"
    Then defined casino(s) is shown
    And user may play in this casino

    Examples:
      | casinoName   |
      | dragontiger  |
      | Keno         |
    # Next one will fail - to show how test will fails
      | NegativeTest |

