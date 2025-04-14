**Pet Store API**

**Test cases covered in the API automation suite:**

API automation suite is used to perform CRUD operations using different HTTP methods: GET, POST, PUT, DELETE.

` `GET: 

1. Send GET request to verify that Pet exists.
1. Verify correct HTTP response status code is returned when sending GET request.
1. Verify correct details of Pet are fetched when sending GET request.

POST:

1. Send POST request to add a new Pet.
1. Verify correct HTTP response status code is returned when sending POST request.
1. Verify correct Pet Id is received when sending POST request.
1. Send GET request with same Pet Id to verify correct Pet detail is fetched.

PUT:

1. Send POST request to add a new Pet.
1. Verify correct HTTP response status code is returned when sending POST request.
1. Verify correct Pet Id is received when sending POST request.
1. Send PUT request to update pet name with same Pet Id.
1. Verify correct HTTP response status code is returned when sending PUT request.
1. Send GET request with same Pet Id to verify that pet name is correctly updated.

DELETE:

1. Send POST request to add a new Pet.
1. Verify correct HTTP response status code is returned when sending POST request.
1. Verify correct Pet Id is received when sending POST request.
1. Send DELETE request to delete the pet using Pet Id.
1. Verify correct HTTP response status code is returned when sending DELETE request.
1. Verify the response message “Pet Deleted”.
1. Send GET request with same Pet Id to verify that pet is deleted.
1. Verify the response message “Pet not found”.

**Outline of automating proposed scenarios on different levels of testing pyramid.**

` `API layer of an application is most crucial part of software component. It provides interface between the different modules of the application which helps to test the integration of different components/modules of the application. 

API testing lies in the middle layer which is the integration testing after the unit testing is performed for each component of the application.

From top to bottom, the main layer include:

1. UI/Exploratory tests
1. Integration tests
1. Unit tests

Pros:

1. Finding bugs at the early stages of software development.
1. Faster execution, API testing is generally fast in execution as compared to UI testing.
1. Language independence
1. Does not simulate real users interacting with elements of your webpage.

Cons:

1. Does not simulate real users interacting with elements of your webpage.
1. Does not give idea how user friendly the application is.

**Technical Document:** 

Tech Stack, Libraries and Dependencies used:

- Java JDK 15.0.2
- RestAssured Libraries
- GSON, JackSon libraries for POJO classes implementation
- TestNG
- Maven

**Project Specification:**

RestAssured has been used for the implementation of automation suite which is an open-source java library for testing RESTful Web API.

**Folder structure:**

Files: contains payload to AddPetRequest and UpdatePetRequest.

Pojo: contains the Plain Old Java Object classes to create request JSON payload and methods to fetch from response JSON payload.

Tests: contains all the tests to perform CRUD operations on the API pet store.

Utils: contains the BaseSpec that includes RequestSpecificationBuilder and RespnseSpecifcationBuilder methods.

testng.xml: to run the test cases.

Pom.xml: contains the maven dependencies.

**To run the tests**

1. Clone the project from the repository shared.
1. Download the maven dependencies.
1. Run the testng.xml file using TestNg.
