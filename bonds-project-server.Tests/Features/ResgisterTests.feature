Feature: CoachesServiceTest
As a Coach
I want to create an account
In order to use the app.

    Background:
        Given the Endpoint https://localhost:8080/api/v1/Coaches is available

    @coach-register
    Scenario: Register a coach with Unique Email
        When a Post Request is sent
            | FirstName  | LastName             | SelectedGame | NickName | Email | Password |
            | Sample name | Sample LastName    | Dota         | NickName | Email | 12345678 |
        Then A Response with Status 200 is received
        And a coach Resource is included in Response Body
          | NickName  |
          | Sample    |

    @coach-register
    Scenario: Register with existing Email
        Given A coach is already stored 
         | FirstName  | LastName             | SelectedGame | NickName | Email | Password |
         | Sample name| Sample LastName      | Dota         | NickName | Email | 12345678 |
        When a Post Request is sent
        Then A Response with Status 400 is received
        And An Error Message with value "User with Email already exists." is returned

    Scenario: Register with existing First Name and Last Name
        Given A coach is already stored 
         | FirstName  | LastName             | SelectedGame | NickName | Email | Password |
         | Sample name| Sample LastName      | Dota         | NickName | Email | 12345678 |
        When a Post Request is sent
        Then A Response with Status 400 is received
        And An Error Message with value "Person already exists." is returned