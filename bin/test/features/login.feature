@login
Feature: Login Validation

  @login
  Scenario Outline: Login to Application
    Given I launch application
    When I login using "<username>" and "<password>"
    Then I verify the login is success

    Examples: 
      | username | password |
      | Admin    | admin123 |
