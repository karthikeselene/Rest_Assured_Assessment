Feature: Validate country wise data of the corona cases data
  
  As a user, I want to check total cases of covid for UK

  Scenario: UK citizen can able to get the correct corona cases from the api
    Given UK citizen able can access the collect api to know the covid cases of UK
    When they hit the get method of the collect api to know the "UK" covid cases
    Then they able to get the total cases of "16,333,980" for the UK country

  Scenario: UK citizen could not able get the corona cases from the api with invaild query input
    Given UK citizen able can access the collect api to know the covid cases of UK
    When they hit the get method with the invalid "QWE" query param
    But they able to get the empty corona cases result

  Scenario: UK citizen could not able get the corona cases details with unauthorized api token
    Given UK citizen able can access the collect api to know the covid cases of UK
    When they hit the get method with unauthorized api to know the "UK" covid cases
    But they able to get unauthorized response
