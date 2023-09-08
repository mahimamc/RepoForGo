Feature: Validating Employee API

Scenario: Validating the create Employee
Given Employee Payload
When user calls "createEmployee" api with post http request
Then The API call got success with status code 201
And The status in the response body is OK
