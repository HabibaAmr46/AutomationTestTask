package APITests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import apis.Requests;
import apis.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class loginTests {
	
	//Valid Data
	String merchantEmail="merchant@foodics.com";
	String password="123456";
	String token="Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";
	
	
	public JsonPath JsonPathFinder (Response r)
	{
		return new JsonPath(r.asString());
	}
	
	@Test
	public void validLoginTest() throws IOException
	{
		
		User data=new User(merchantEmail,password,token);
		Response reponse=Requests.loginRequest(data);
	
		Assert.assertEquals(reponse.getStatusCode(), 200);
		
		JsonPath e=JsonPathFinder(reponse);
		Assert.assertFalse(e.getString("token").equals(null));
	}

	
	@Test
	public void invalidLoginTestPassword() throws IOException
	{
		
		User data=new User(merchantEmail,"1234567",token);
		Response reponse=Requests.loginRequest(data);
	
		Assert.assertNotEquals(reponse.getStatusCode(), 200);
	}
	

	@Test
	public void invalidLoginTestPasswordWithEmptyEmail() throws IOException
	{
		
		User data=new User("",password,token);
		Response reponse=Requests.loginRequest(data);
	
		Assert.assertNotEquals(reponse.getStatusCode(), 200);
	}
}
