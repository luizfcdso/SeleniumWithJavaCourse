
@tag
Feature: Purchase the order from Ecommerce WebSite
  I want to use this template for my feature file

	Background:
	
	Given I landed on Ecommerce Page

  @Regression
  Scenario Outline: Title of your scenario outline
    Given Logged in with user <username> and password <password>
    When I add the product <productName> to Cart
    And This product <productName> has been added and submit the Order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | username 							| password 		| productName 		|
      | luizxtcosta@gmail.com | Test@123 | ADIDAS ORIGINAL |
 
