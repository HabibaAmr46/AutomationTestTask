package apis;

import java.io.IOException;


import config.PropertiesFile;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification {
	
	private static  RequestSpecBuilder requestSpec;
	private static ResponseSpecBuilder responseSpec;
	
	
	public static RequestSpecification getRequestSpec() throws IOException
	{
		return new RequestSpecBuilder()
				.setBaseUri(PropertiesFile.getProperties().getProperty("baseURI"))
				.setBasePath(PropertiesFile.getProperties().getProperty("basePath"))
				.setContentType(ContentType.JSON)
				.log(LogDetail.ALL).build();
	}
	
	
	public static ResponseSpecification getResponseSpec() throws IOException
	{
		return new ResponseSpecBuilder()
				.log(LogDetail.ALL).build();
	}
	

}
