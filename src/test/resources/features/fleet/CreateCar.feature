@create_car
Feature: Create a car
  As user, I want to be able to add new cars
  # this is scenario that has dataTable, that transforms into dat structure - list /map or list of maps
  # this is done because of the amount of data we have for scenario / different data is provided
  Scenario: Add new car
    Given user is on the login page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create a car button
    Then user creates a car with following info:
      | License Plate | Driver    | Location | Model Year | Color |
      | SDET          | Pro Racer | London   | 2020       | Red   |
    And user verifies that car info is displayed:
      | License Plate | Driver    | Location | Model Year | Color |
      | SDET          | Pro Racer | London   | 2020       | Red   |


  @create_car_ddt
  Scenario Outline: Add new car for driver <driver>
    Given user is on the login page
    When user logs in as a sales manager
    Then user navigates to "Fleet" and "Vehicles"
    And user click on create a car button
    Then user creates a car with following info:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license_plate> | <driver> | <location> | <model_year> | <color> |
    And user verifies that car info is displayed:
      | License Plate   | Driver   | Location   | Model Year   | Color   |
      | <license_plate> | <driver> | <location> | <model_year> | <color> |


    Examples: cars test data
      | license_plate | driver      | location        | model_year | color  |
      | 000           | pilot       | Washington D.C. | 2010       | purple |
      | 123           | test_driver | New York        | 2022       | black  |
      | 9122          | pro_driver  | Portland        | 2008       | brown  |

    #in scenario : if we include more than one car it is possible but if first car fails then the rest will not run
    # in scenario outline : we use it when we have same steps but need to test with different data
    #                       when we create multiple cars even if one of the test is failing the rest will still continue running
    # similar to testNg = scenario outline => as many as you provide examples, that many times scenario will run

  #cucumbr will replace <> with values and this test will run 3 times