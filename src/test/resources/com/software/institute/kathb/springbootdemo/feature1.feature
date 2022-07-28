Feature: Getting and setting an actor name

  Scenario: getting the actor first name
    Given I have an actor with first name set to "John"
    When I get the actor first name
    Then the actor first name returned should be "John"

  Scenario: setting the actor first name
    Given I have an actor with first name set to "John"
    When I set the actor first name to "Jim"
    And I get the actor first name
    Then the actor first name returned should be "Jim"
