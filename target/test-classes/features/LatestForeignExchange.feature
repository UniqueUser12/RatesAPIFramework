Feature: Validating RatesApi

Scenario: Verify Latest Foreign Exchange Rates API
Given Latest Foreign Exchange Rates API 
When Latest Foreign Exchange Rates API is available 
Then the api call is success with statuscode is 200
And "base" in response body is "EUR"
And  ratesList is not empty
And "date" in the response is the current date


Scenario: Verify Negative scenario for Latest Foreign Exchange Rates API
Given Latest Foreign Exchange Rates API 
When Latest Foreign Exchange Rates API is incorrect 
Then response status code is 400
And "error" in response contains "time data 'latessstttt' does not match format '%Y-%m-%d'"

Scenario:Verify Latest Foreign Exchange Rates API with symbol and base
Given Latest Foreign Exchange Rates API
When Latest Foreign Exchange Rates API is available with symbol and base
Then the api call is success with statuscode is 200
And "base" is "USD"
And response does contains rates.GBP
	

	




