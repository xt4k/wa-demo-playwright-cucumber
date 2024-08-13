Feature:  Efbet login/logout functionality
  'When registered player open Efbet.net, he can login'

  Scenario: Check registered user `sign in` functionality
    Given user navigated to homepage
    When user click `SIGN IN`
    And user set email
    And user set password
    And user click `SING IN`
    Then user successfully sign in