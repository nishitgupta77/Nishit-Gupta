package tests;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
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

public class UpdatePet {
	
	@Test
	public static void UpdatePet() throws IOException
	{
		
		//1. Add a new Pet
		String response = given()
		.spec(BaseSpec.request())
		.body(payload.AddPetRequestPayload())
		.when()
		.post("api/v3/pet")
		.then().spec(BaseSpec.response())
		.extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(response);
		int petId = json.get("id");
			
		//2. Update the Pet Name
		given()
		.spec(BaseSpec.request())
		.body(payload.UpdatePetRequestPayload())
		.when()
		.put("api/v3/pet")
		.then().spec(BaseSpec.response())
		.extract().response().asPrettyString();
		
		
		//3. Get call to verify that pet is Updated by name
		Pet pet = given().spec(BaseSpec.request())
				.expect()
				.defaultParser(Parser.JSON)
				.when()
				.get("api/v3/pet/"+petId)
				.as(Pet.class);
		
		Assert.assertEquals(pet.getName(), "Honey");

	}

}
