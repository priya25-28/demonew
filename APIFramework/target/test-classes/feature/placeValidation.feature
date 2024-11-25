Feature: Validating place API'S

Scenario: Verify if place is being successfully added using add place API
Given: Add place payload
When: when user calls add place api with post http request
Then: The api call is success with status code is 200
And: Status code is ok