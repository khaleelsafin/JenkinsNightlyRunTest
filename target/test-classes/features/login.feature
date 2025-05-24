@login @regression
Feature: Login functionality

  @smoke @positive
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter username "standard_user" and password "secret_sauce"
    And I click on the login button
    Then I should be redirected to the inventory page
    And I should see the title "Products"

#  @negative
#  Scenario: Unsuccessful login with invalid credentials
#    Given I am on the login page
#    When I enter username "invalid_user" and password "wrong_password"
#    And I click on the login button
#    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
#
#  @wip @positive
#  Scenario: Successful login with problem_user
#    Given I am on the login page
#    When I enter username "problem_user" and password "secret_sauce"
#    And I click on the login button
#    Then I should be redirected to the inventory page