package tests;
import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
import pojo.Category;
import pojo.Pet;
import pojo.Tag;
import utils.BaseSpec;

public class PostPet {
	
	@Test
	public static void PostPet() throws IOException
	{	
	
		//1. Add a new Pet
		 String response = given().spec(BaseSpec.request())
		.body(payload.AddPetRequestPayload())
		.when()
		.post("api/v3/pet")
		.then()
		.spec(BaseSpec.response())
		.extract().response().asPrettyString();
		
		JsonPath json = new JsonPath(response);
		int petId = json.get("id");
	
		
		//2. Get call to verify that pet is added
		Pet pet =given().spec(BaseSpec.request())
				.expect()
				.defaultParser(Parser.JSON)
				.when()
				.get("api/v3/pet/"+petId)
				.as(Pet.class);
		
		Assert.assertEquals(pet.getName(), "Pubi");
	
	}

}
