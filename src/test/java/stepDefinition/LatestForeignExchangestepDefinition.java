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
import io.restassured.path.json.JsonPath;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import pojo.ratesResp;
//import resources.TestDataBuild;
import resources.Utils;
import pojo.RateList;

import static io.restassured.RestAssured.*;

public class LatestForeignExchangestepDefinition extends Utils {
	RequestSpecification res;
	Response response;
//	TestDataBuild data = new TestDataBuild();

	@Given("Latest Foreign Exchange Rates API")
	public void Latest_Foreign_Exchange_Rates_API() throws IOException {
		res = given().header("Content-Type", "application/json").spec(requestSpecification());

	}

	@When("Latest Foreign Exchange Rates API is available")
	public void latest_Foreign_Exchange_Rates_API_is_available() {
		response = res.when().get("latest").then().extract().response();
		// System.out.println(response.asString());

	}

	@Then("the api call is success with statuscode is {int}")
	public void the_api_call_is_success_with_statuscode_is(Integer int1) {
		assertEquals(response.getStatusCode(), 200);
	}

	@Then("{string} in the response is the current date")
	public void in_the_response_is_the_current_date(String key) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		// Create object of SimpleDateFormat class and decide the format
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// get current date time with Date()
		Date date = new Date();

		// Now format the date
		String expectedvalue = dateFormat.format(date);

		// Print the Date
		System.out.println(expectedvalue);
		assertEquals(actualval, expectedvalue);

	}

	@Then("ratesList is not empty")
	public void ratesList_is_not_empty() throws IOException {
		/*
		 * ratesResp gc=given().header("Content-Type",
		 * "application/json").spec(requestSpecification()).when().get("/latest")
		 * .as(ratesResp.class); boolean listempty=gc.rates.isEmpty();
		 * assertEquals(listempty,false);
		 */
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String expectedvalue) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		assertEquals(actualval, expectedvalue);
	}

	@When("Latest Foreign Exchange Rates API is incorrect")
	public void latest_Foreign_Exchange_Rates_API_is_incorrect() {
		response = res.when().get("latessstttt").then().extract().response();

	}

	@Then("response status code is {int}")
	public void response_status_code_is(Integer int1) {
		assertEquals(response.getStatusCode(), 400);

	}

	@Then("{string} in response contains {string}")
	public void in_response_contains(String key, String expectedvalue) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		assertEquals(actualval, expectedvalue);
	}

	@When("Latest Foreign Exchange Rates API is available with symbol and base")
	public void latest_Foreign_Exchange_Rates_API_is_available_with_symbol_and_base() {
		response = res.queryParam("base", "USD").queryParam("symbols", "GBP").when().get("latest").then().extract()
				.response();
	}

	@Then("{string} is {string}")
	public void is(String key, String expectedvalue) {
		String actualValue = getJsonpath(response, key);
		String actualval = actualValue.replaceAll("[\\[\\]]", "");
		assertEquals(actualval, expectedvalue);
	}

	@Then("response does contains rates.GBP")
	public void response_does_contains_rates_GBP() {
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		Assert.assertNotNull(js.get("rates.GBP").toString());
	}

}
