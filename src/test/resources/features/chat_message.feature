Feature:  Efbet chat functionality
  user can send message to chat

  Scenario Outline: Check efbet chat functionality
    Given user navigated to homepage
    When user click 'efbet chat'
    And user click 'Start Conversation' button
    And user set email 'aa@bb.cc'
    And user set language "<language>"
    And user send message "<message>"
    Then sent message in chat history has text "<message>"

    Examples:
      | language | message |
      | English  | hello   |