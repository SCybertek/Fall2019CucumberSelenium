@smoke_test
Feature: Smoke Test

  Scenario Outline: Go to <module> and verify title: <title>
    Given user is on the login page
    When user logs in as "<user_type>"
    And user navigates to "<tab>" and "<module>"
    Then user verifies that page title is "<title>"

    Examples:
      | user_type     | tab        | module          | title                                                              |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |
# we can aslo add create a cra since it is a basic functionality of the app
  # up until 15 min . if we have still time we will add more scenario
  # but smoke is for JUST main functionality