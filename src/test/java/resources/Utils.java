package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils
{
	//logging is also implemented here at global level
	public static RequestSpecification req;
	public static Properties prop;
	static String currentUsersHomeDir = System.getProperty("user.dir");
	static String propfile = currentUsersHomeDir +""+"\\src\\test\\java\\resources\\global.properties";

	//here the logging file will be rewritten with each new test case execution
	//so first check if req is null then only once log file will begenrated,
	//if not null then too logging will happen inthe same file
public RequestSpecification requestSpecification() throws IOException
{
	if(req==null)
	{
	PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
	//fileoutputstream class will automatically create the log file
	req=new RequestSpecBuilder().setBaseUri(getglobalValue("baseuri"))
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON).build();
	return req;
}
	return req;
}
public static String getglobalValue(String key) throws IOException
{
	FileInputStream fis=new FileInputStream(propfile);
	prop=new Properties();
	prop.load(fis);
	return prop.getProperty(key);
	
}

public String getJsonpath(Response response,String key)
{
	String resp= response.asString();
	JsonPath js=new JsonPath(resp);
	return js.get(key).toString();

}

	/*
	 * public static String getReportConfigPath(){ String reportConfigPath =
	 * prop.getProperty("reportConfigPath"); if(reportConfigPath!= null) return
	 * reportConfigPath; else throw new
	 * RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"
	 * ); }
	 */
}