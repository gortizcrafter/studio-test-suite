package org.craftercms.studio.test.api;

import org.craftercms.studio.test.utils.JsonTester;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;



/**
 * Created by gustavo ortiz 
 */

public class LoginAPITest {

    private JsonTester api;

    public LoginAPITest(){
        api = new JsonTester("http","localhost",8080);
    }

    @Test
    public void login(){
    	Map<String, Object> json = new HashMap<>();
		json.put("username", "admin");
		json.put("password", "admin");
		api.post("/studio/api/1/services/api/1/security/login.json").json(json).execute().status(200);
    }


 
}
