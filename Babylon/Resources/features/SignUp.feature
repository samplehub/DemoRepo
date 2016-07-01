 Feature: Use the Babylon Health app to find GP's
        So that I can take appointment online
        As a new customer
        I want to have a video chat with GPs online
    
    Scenario Outline: Register to Babylon Health App
        Given User opens Babylon Health App
        When User clicks Sign Up Button
        And User enters all the "<Email>" , "<Password>" , "<First Name>" and "<Last Name>"  
        Then New Account is created for User
        And User Clicks on Avatar Icon
        Then User counts Number of Settings
    
     Examples:
        |Email|Password|First Name|Last Name|
        |oewrireo@yahoo.com|Babylon123|Babylon|Health|