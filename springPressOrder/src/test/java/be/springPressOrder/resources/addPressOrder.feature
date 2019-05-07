Feature: Add press order

  It should be possible to add an press order. Just after adding an order the details should be shown

  Scenario: Add one press order
    Given I am on the page where I can add one pressOrder
    When I enter 100 in the fruit amount field
    And I enter 99 in the juice field
    And I enter 100 in the maximum(max) juice field
    And I choose "Planned" status
    And I press submit
    Then I should see the following on the screen
      | label        | data           |
      | Amount:      | 100            |
      | Juice:       | AppleJuice     |
      | Status       | Planned        |
      | ClientId:    | 2              |
    When I click the pressOrder link
    Then I should see a list cointaining "AppleJuice"
    And I close the browser

