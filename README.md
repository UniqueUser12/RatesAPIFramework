# RatesAPIFramework
RatesAPIFramework is designed to test the Latest Foreign Exchange Rates API and the Specific Exchange rates API

# How to build
Clone the project in the local system and navigate the command prompt to the project path and then need to type mvn -e test verify and enter the build will happen.
Alternatively run the TestRunner.java as a junit test present under cucumber.Options package.

# How to use
Tester needs to change the base uri in the global.properties file.
Also the endpoints can be changed in the LatestForeignExchangestepDefinition.java and SpecificDatestepDefinition.java files.

The reports of the testcases are generated as "overview-features.html" file under the target folder.

The logs are generated in logging.txt file under logs folder.

