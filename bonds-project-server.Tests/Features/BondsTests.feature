Feature: AdvisoriesServiceTest
As a Coach
I want to create a new advisory
In order to promote a game.

    Background:
        Given the Endpoint https://localhost:8080/api/v1/Coaches/1/Advisories is available

    @create-advisory
    Scenario: A coach wants to create a new Advisory 
        When a Post Request is sent
        | Date  | 
        | today |
        Then A Response with Status 200 is received
        And a coach Resource is included in Response Body
        
    @create-advisory
    Scenario: A coach wants to create a new Advisory without a date
        Given A date is Null
         | Date | 
         | Null |
        When a Post Request is sent
        Then A Response with Status 400 is received
        And An Error Message with value "Tournament can not be created  without a date" is returned


Feature: AdvisoriesServiceTest_Subscribe
As a Student
I want to join an Advisory
In order to learn from a Coach.

 Background:
        Given the Endpoint https://localhost:8080/api/v1/Coaches/1/Tournaments is available

        @join-advisory
        Scenario: A student wants join into an Advisory
        When a update Request is sent
        |Student|
        |Student|
        And a Coach accept the request
        Then A Response with Status 200 is received
        And a coach Resource is included in Response Body
         Scenario: A student wants join into an Advisory but it's already registered
        When a update Request is sent
        |Student|
        |Student|
        And a Coach accept the request
        Then A Response with Status 400 is received
        And An Error Message with value "Already registered" is returned
        