Feature: Validating RatesApi

Scenario: Verify Specific Date Range Rates API
Given SpecificDateRange API 
When SpecificDateRange is available 
Then the statuscode is  200
And "base"  is "EUR"
And  ratesList is not empty
And "date" in the response is the the one passed in the request.


Scenario: Verify Negative scenario for Specific Date Range Rates API
Given SpecificDateRange API  
When User passes invalid date format in the request 
Then the status code is 400
And "error" in the response contains "time data" 
