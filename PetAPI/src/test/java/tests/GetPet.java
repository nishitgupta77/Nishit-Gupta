package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.Pet;
import utils.BaseSpec;

import static io.restassured.RestAssured.*;


public class GetPet {
	
	@Test
	public static void GetPet()
	{
		
		//1. Get call to verify that pet exist
		Pet pet = given().spec(BaseSpec.request())
				.header("Content-Type","application/json").expect()
				.defaultParser(Parser.JSON)
				.when()
				.get("api/v3/pet/1")
				.as(Pet.class);
		
		Assert.assertEquals(pet.getCategory().getName(), "Cats");
		Assert.assertEquals(pet.getTags().size(), 2);
		Assert.assertEquals(pet.getStatus(), "available");
	}

}
