Feature: CybersServiceTest
As a Cyber user
I want to create a new account
In order to promote my space.

    Background:
        Given the Endpoint https://localhost:8080/api/v1/Coaches/1/Tournaments is available

    @cyber-register
    Scenario: A cyber user wants to register
        When a Post Request is sent
        | FirstName   | LastName         |CyberName    | Bibliography | Address | Email | Password |
        | Sample name | Sample LastName  |Sample text | Sample text  | Sample  | Email | 12345678 |
        Then A Response with Status 200 is received
        And a Succest message with value "Succes post" is returned
        
    @cyber-register
    Scenario: A cyber user wants to register with missing address
        Given A register forrm is missing address 
        When a Post Request is sent
        | FirstName   | LastName         |CyberName    | Bibliography | Address | Email | Password |
        | Sample name | Sample LastName  |Sample text  | Sample text  | Null  | Email | 12345678 |
        Then A Response with Status 400 is received
        And An Error Message with value "Tournament can not be created  without an Address" is returned
        
