package testing_API;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Test1 {

	@Test(priority=1,description="GET method")
	public void testGET() {

		given().get("https://reqres.in/api/users?page=2").then().
		statusCode(200).
		body("data.id[1]", equalTo(8)).
		body("data.first_name", hasItems("Michael","Lindsay")).
		log().all();

	}
	@SuppressWarnings("unchecked")
	@Test(priority=2,description="POST method")
	public void testPOST() {

		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BA");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201 );

	}
	
	@SuppressWarnings("unchecked")
	@Test(priority=3,description="PUT method")
	public void testPUT() {

		JSONObject request = new JSONObject();
		request.put("name", "chaya");
		request.put("job", "BAA");

		System.out.println(request);
		System.out.println(request.toString());

		given().
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().statusCode(200);

	}
	
	@Test(priority=4,description="DELETE method")
	public void testDELETE() {

		JSONObject request = new JSONObject();
		given().
		body(request.toJSONString()).
		when().
		delete("https://reqres.in/api/users/2").
		then().statusCode(204).
		log().all();

	}
}

