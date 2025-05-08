
@tag
Feature: Purchase order from e-commerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Ecommerce Page
  
  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Login with UserName <name> and Password <password>
    When I add product <productName> to the cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed.

    Examples: 
      | name                      |  password       |   productName        |
      | pvramana1819@gmail.com    |   Venkat@1      | ZARA COAT 3					 |
     