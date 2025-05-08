
@tag
Feature: Validate login
  I want to use this template for my feature file


  @ErrorValidation
  Scenario Outline: Negative Test on Validate Login
  	Given I landed on Ecommerce Page
    When Login with UserName <name> and Password <password>
    Then Check error message "Incorrect email or password."

    Examples: 
    | name                      |  password       |   
    | pvramana1819@gmail.com    |    Venkat@18    |
