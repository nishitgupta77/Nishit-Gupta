package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseSpec {

	public static RequestSpecification request()
	{
		 return new RequestSpecBuilder()
				.setBaseUri("http://localhost:8080/")
				.setContentType(ContentType.JSON)
				.build();
	}
	
	public static ResponseSpecification response()
	{
		return new ResponseSpecBuilder()
			    .expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
}
