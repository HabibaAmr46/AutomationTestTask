package apis;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.io.IOException;
public class Requests {
	
	
	public static Response loginRequest(User data) throws IOException
	{
		
		return given().
				spec(Specification.getRequestSpec()).
				body(data).
				when().
				post("/login")
				.then()
				.spec(Specification.getResponseSpec())
				.extract().response();
				
	}

}
