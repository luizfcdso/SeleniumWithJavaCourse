
@tag
Feature: Error validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with user <username> and password <password>
    Then "Incorrect email or password." is showing

    Examples: 
      | username  						| password | 
      | luizxtcosta@gmail.com | Test123  |
     
