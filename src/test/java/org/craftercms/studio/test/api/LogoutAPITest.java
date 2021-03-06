package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;


/**
 * Created by gustavo ortiz
 */

public class LogoutAPITest {

    private JsonTester api;

    public LogoutAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test
    public void logout(){
    	Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/logout.json").json(json).execute().status(200)
		.json("$.message", is("OK")).debug();;
    }


 
}
