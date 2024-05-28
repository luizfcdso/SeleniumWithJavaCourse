@tag
Feature: End to end buying clothes
  I want to use this template for my feature file


	Background:
	Given realizo o login com  "luizxtcosta@gmail.com" e senha "Test@123"
	
	
  @Regression
  Scenario: Title of your scenario
    When adiciono os produtos no carrinho <produto1> 
   	And estes produtos foram add <produto1>
    Then minha compra foi feita
    

    Examples: 
      |        produto1  |														
  		| Hummingbird printed t-shirt | 
   		| Hummingbird printed sweater |
