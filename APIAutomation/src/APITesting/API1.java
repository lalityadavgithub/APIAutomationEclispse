package APITesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import File.Payload;
import File.ReUsableMethods;

public class API1 {

	public static void main(String[] args) {
		
		//given - all input details
		//when - Submit the API
		//Then - validate the response

		RestAssured.baseURI="https://dtpapitestv1.mloyalcapture.com";
		String response =given().log().all()
		.header("Username","fTw42vIbHSTW8xNJSU3GH/hcmAE3X5kQq1QZuG56Qa0=")
		.header("Password","ITYh76YdXLBbMv1HaqjNhltSikIoki5d9QmeHyZPT4o=")
		.header("Content-Type","Application/Json")
		.header("Authorization","Key AFF72766A04E47A289082CB1251625AA")
		.body(Payload.AddPlace()).when().post("/HLFLApi/Transaction/CreateCustomer")
		.then().assertThat().statusCode(200)
		//.body("ClientCode", equalTo("HLFL"))
		//.header("X-Powered-By", "ASP.NET")
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response); //for parsing json
		String clientCode=js.getString("ClientCode");
		System.out.println(clientCode);
		
		//update place using put
		
		String newaddress="Noida sec 98";
		
		given().log().all()
		.header("Username","fTw42vIbHSTW8xNJSU3GH/hcmAE3X5kQq1QZuG56Qa0=")
		.header("Password","ITYh76YdXLBbMv1HaqjNhltSikIoki5d9QmeHyZPT4o=")
		.header("Content-Type","Application/Json")
		.header("Authorization","Key AFF72766A04E47A289082CB1251625AA")
		.body("")
		.when().put("")
		.then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		
		//Get Place >>GET Http method
	String getResponsePlcase= given().log().all().queryParam("key", "quclick123")
		.queryParam("clientCode", clientCode)
		.when().get()
		.then().assertThat().log().all().statusCode(200).extract().response().asString();
	
	
	JsonPath js1= ReUsableMethods.rawToJson(getResponsePlcase);
	String actualAddress=js1.getString("address");
	Assert.assertEquals(actualAddress, newaddress);	
	
	//Cucumber Junit , Testng
	
		
	}

	
	}


