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

public class CreateUserAPITest {

	private JsonTester api;

	public CreateUserAPITest() {
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
				.json("$.message", is("OK")).debug();

	}
	
	@Test(priority=2)
	public void testUserExist() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "jane.doe");
		json.put("password", "SuperSecretPassword123#");
		json.put("first_name", "Jane");
		json.put("last_name", "Doe");
		json.put("email", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(409)
				.header("Location", is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
				.json("$.message", is("User already exists")).debug();

	}

	@Test(priority=3)
	public void testInvalidParameters() {
		Map<String, Object> json = new HashMap<>();
		json.put("usernamed", "jane.doe");
		 json.put("first_named", "Jane");
		 json.put("last_named", "Doe");
		 json.put("emaild", "jane@example.com");
		api.post("/studio/api/1/services/api/1/user/create.json").json(json).execute().status(400)
				.json("$.message", is("Invalid parameter(s): [username, password, firstname, lastname, email]")).debug();

	}
	
//	 @Test(priority=4)
//	 public void testInternalServerError(){
//	 Map<String,Object> json=new HashMap<>();
//	 json.put("usernamed", "jane.doe");
//	 json.put("passwordd", "SuperSecretPassword123#");
//	 json.put("first_named", "Jane");
//	 json.put("last_named", "Doe");
//	 json.put("emaild", "jane@example.com");
//	 api.post("/studio/api/1/services/api/1/user/create.json")
//	 .json(json)
//	 .execute()
//	 .status(500)
//	 .header("Location",is("http://localhost:8080/studio/api/1/services/api/1/user/get.json?user=jane.doe"))
//	 .json("$.message", is("Internal server error")).debug();
//	
//	
//	 }

	
	
	
	@Test(priority=5)
	public void testLogout() {
		Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;

	}


}
