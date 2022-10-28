@logout
Feature: Logout Validation

  @logout
  Scenario Outline: Logout from Application
    Given I launch application
    When I login using "<username>" and "<password>"
    Then I verify the login is success
    And I verify the logout is success

    Examples: 
      | username | password |
      | Admin    | admin123 |
