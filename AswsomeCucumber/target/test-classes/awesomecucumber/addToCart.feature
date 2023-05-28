Feature: Cart

  @cart
  Scenario: Add to cart
    Given I'm on the store page
    When I add a "blue shirt" to the cart
    Then I should see 1 "blue shirt" in the cart
