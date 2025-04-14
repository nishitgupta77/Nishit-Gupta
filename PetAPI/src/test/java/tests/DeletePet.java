package tests;

import static io.restassured.RestAssured.given;

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

public class DeletePet {
	
	@Test
	public static void DeletePet()
	{
		//1. Add a new Pet
		String response = given().spec(BaseSpec.request())
				.body(payload.AddPetRequestPayload())
				.when()
				.post("api/v3/pet")
				.then().spec(BaseSpec.response())
				.extract().response().asPrettyString();

		JsonPath json = new JsonPath(response);
		int petId = json.get("id");

		//2. Delete the Pet		
		String responseMsg = given().spec(BaseSpec.request())
				.when()
				.delete("api/v3/pet/"+ petId)
				.then().spec(BaseSpec.response()).extract().response()
				.asPrettyString();

		Assert.assertEquals(responseMsg, "Pet deleted");

		//3. Get call to check Pet found
		String getrespMsg = given().spec(BaseSpec.request())
				.when()
				.get("api/v3/pet/"+ petId)
				.then().assertThat().statusCode(404)
				.extract().response()
				.asPrettyString();

		Assert.assertEquals(getrespMsg, "Pet not found");
	}

}
