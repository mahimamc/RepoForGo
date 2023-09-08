Feature: Validate Create Repository

Scenario: Verify Create Repo API
Given Create Repo payload
When User calls "/user/repos" post api call
Then api call get successful with status code 201
Then Verify Repository "name" is "API_Testing_Go1"
Then Verify Repository "description" is "API Repo Created for Go Telcom"

Scenario: Verify Delete Repo API
Given Create Repo payload
When 	User calls Delete api "/repos/mahimamc/" post api call
Then 	api call get successful with status code 204