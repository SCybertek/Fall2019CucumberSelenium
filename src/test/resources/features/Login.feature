@login
Feature:Login
  As user, I want to be able to login with username and password
  # Agile story

  # Test Method = Test Case = Scenario ( or test description)
  # Test + DataProvider = Scenario Outline = Examples table
  # every step has to have code implementation!

  Background: open login page
    Given user is on the login page

  @sales_manager
  Scenario: Login as sales manager and verify that file title is Dashboard
    #Given user is on the login page
    When  user logs in as a sales manager
    Then  user should verify that title is a Dashboard

  @store_manager
  Scenario: Login as store manager and verify that title is Dashboard
    #Given user is on the login page
    When user logs in as a store manager
    Then user should verify that title is a Dashboard

  @driver @dashboard
  Scenario: Login as driver and verify that title is a Dashboard
    #Given user is on the login page
    When user logs in as a driver
    Then user should verify that title is a Dashboard

  @login_with_params #tags to give idea what this scenario means
  Scenario: Login with parameters
    When user enters "storemanager85" username and "UserUser123" password
    Then user should verify that title is a Dashboard
      # why double quotes ? = to inject in step def as parameters
      # even if you change the inside of "" the step will not need extra implementation
      # string /int/boolean = they all can be but String is more widely used as a parameter