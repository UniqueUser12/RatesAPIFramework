package cucumber.Options;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

//import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import resources.Utils;


@CucumberOptions(features="src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",
glue= {"stepDefinition"},
monochrome = true)
@RunWith(Cucumber.class)
public class TestRunner 
{
	/*
	 * @AfterClass public static void writeExtentReport() {
	 * Reporter.loadXMLConfig(new File(Utils.getReportConfigPath())); }
	 */
}
