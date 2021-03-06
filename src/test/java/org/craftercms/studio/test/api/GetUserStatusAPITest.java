package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;

/**
 * Created by Gustavo Ortiz Alfaro.
 */

public class GetUserStatusAPITest {

	private JsonTester api;

	public GetUserStatusAPITest() {
		api = new JsonTester("http", "localhost", 8080);
	}

	@BeforeTest
	public void login() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
	}

	@Test(priority=1)
	public void testCreateUser() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(201)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("OK"));

	}
	
	@Test(priority=2)
	public void testGetUserStatus() {
		Map<String, Object> json = new HashMap<>();
		api.get("http://localhost:8080//studio/api/1/services/api/1/user/status.json?username=jane.doe")
		.json(json)
		.execute()
		.status(200)
		.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?username=jane.doe"));
	//	.json("$.message", is("OK"));
		
	}
	
	@Test(priority=3)
	public void testInvalidParameter() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/status.json")
		.json(json)
		.execute()
		.status(400)
		.json("$.message", is("Invalid parameter: username"));

		

	}
	
//	@Test(priority=4)
//	public void testUnauthorized() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("/studio/api/1/services/api/1/user/status.json?username=jane.doeNOT")
//		.json(json)
//		.execute()
//		.status(401)
//		.json("$.message", is("Unauthorized"));
//
//
//	}
	
	
	@Test(priority=5)
	public void testUserNotFound() {
		Map<String, Object> json = new HashMap<>();
		api.get("/studio/api/1/services/api/1/user/status.json?username=jane.doeNOT")
		.json(json)
		.execute()
		.status(404);
		//.json("$.message", is("User not found"));


	}
	
	
	
	
//	@Test(priority=6)
//	public void testInternalServerError() {
//		Map<String, Object> json = new HashMap<>();
//		api.get("/studio/api/1/services/api/1/user/status.json?username=jane.doe")
//		.json(json)
//		.execute()
//		.status(500)
//		.json("$.message", is("Internal server error"))
//
//		.debug();
//		
//	}

}
