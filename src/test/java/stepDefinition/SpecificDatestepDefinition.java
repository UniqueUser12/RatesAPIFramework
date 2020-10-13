package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import junit.framework.Assert;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pojo.ratesResp;
//import resources.TestDataBuild;
import resources.Utils;
import pojo.RateList;

import static io.restassured.RestAssured.*;

public class SpecificDatestepDefinition extends Utils {
	RequestSpecification res1;
	Response response;
//	TestDataBuild data = new TestDataBuild();
	
	static String invalidDate="2020-ss-22";
	static String validDate="2020-10-13";

	@Given("SpecificDateRange API")
	public void specificdaterange_API() throws IOException {
		res1 = given().header("Content-Type", "application/json").spec(requestSpecification());

	}

	@When("SpecificDateRange is available")
	public void specificdaterange_is_available() {
		response = res1.when().get(validDate).then().extract().response();
		System.out.println(response.asString());

	}
	@Then("the statuscode is  {int}")
	public void the_statuscode_is(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string}  is {string}")
	public void is(String key, String expectedvalue) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		assertEquals(actualval, expectedvalue);
	}

	@Then("{string} in the response is the the one passed in the request.")
	public void in_the_response_is_the_the_one_passed_in_the_request(String key) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		assertEquals(actualval, validDate);

	}

	@When("User passes invalid date format in the request")
	public void user_passes_invalid_date_format_in_the_request() {
		response = res1.when().get("/2020-ss-22").then().extract().response();
		System.out.println(response.asString());

	}
	@Then("the status code is {int}")
	public void the_status_code_is(Integer int1) {
		assertEquals(response.getStatusCode(), 400);
	}


@Then("{string} in the response contains {string}")
public void in_the_response_contains(String key, String expectedvalue) {
	String actualValue = getJsonpath(response, key);
	String actualval = actualValue.replaceAll("[\\[\\]]", "");
	assertTrue(actualval.contains(expectedvalue));
	
}

}
