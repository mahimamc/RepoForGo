Feature: SpringBootRestCrudVerification with H2 DB

Scenario: Verification createEmployee api 
Given create the employee payload
When the user calls "/api/v1/employees" with post api call 
Then the api call get successful with status code 200

Scenario: Verification of getAll Employee
Given the user calls "/api/v1/employees" with get api call
Then the api call get successful with status code 200

Scenario: Verification of getEmployee with given Id
Given the user calls "/api/v1/employees/" with get api call with id 3
Then the api call get successful with status code 200

Scenario: Updation of Employee with given Id
Given the user calls "/api/v1/employees/" with put api call with id 3
Then the api call get successful with status code 200

Scenario: Deletion of Employee with given Id
Given the user calls "/api/v1/employees/" with delete api call with id 6
Then the api call get successful with status code 200