package APITesting;


	
	import io.restassured.RestAssured;
	import io.restassured.response.Response;
	import org.testng.Assert;
	import org.testng.annotations.Test;
    import com.fasterxml.jackson.databind.JsonNode;
    import com.fasterxml.jackson.databind.ObjectMapper;

	public class DummyApiPokeman { 

		String BASE_URL;
		@Test(priority = 0)
		public void TestURL() {
	    @SuppressWarnings("unused")
		String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

		}
	    @Test(priority = 1)
	    public void testValidPokemonExistsByName() {
	    	
			Response response = RestAssured.get(BASE_URL + "pikachu/");
	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(response.jsonPath().getString("name"), "lalit");
	    }

	    @Test(priority = 2)
	    public void testValidPokemonExistsById() {
	        
			Response response = RestAssured.get(BASE_URL + "35/");
	        Assert.assertEquals(response.getStatusCode(), 200);
	        Assert.assertEquals(response.jsonPath().getString("name"), "clefairy");
	    }

	    @Test(priority = 3)
	    public void testInvalidPokemonNotFound() {
	        Response response = RestAssured.get(BASE_URL + "invalidpokemon/");
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }

	    @Test(priority = 4)
	    public void testInvalidPokemonIdNotFound() {
	        Response response = RestAssured.get(BASE_URL + "99999/");
	        Assert.assertEquals(response.getStatusCode(), 404);
	    }

	    @Test(priority = 5)
	    public void testCheckPokemonProperties() {
	        Response response = RestAssured.get(BASE_URL + "bulbasaur/");
	        Assert.assertEquals(response.getStatusCode(), 200);

	        String name = response.jsonPath().getString("name");
	        Assert.assertNotNull(name);
	        
	    }
	    @Test(priority = 6)
	    public void testCheckPokemonPropertiesType() {
	    	
	    	Response response = RestAssured.get(BASE_URL + "35/");
	    	try {
	            ObjectMapper objectMapper = new ObjectMapper();
	            JsonNode jsonNode = objectMapper.readTree(response.asString());

	            // Assertions
	            Assert.assertEquals(jsonNode.get("id").asInt(), 35);
	            Assert.assertEquals(jsonNode.get("name").asText(), "clefairy");
	            Assert.assertEquals(jsonNode.get("base_experience").asInt(), 113);
	            Assert.assertEquals(jsonNode.get("height").asInt(), 6);
	            Assert.assertTrue(jsonNode.get("is_default").asBoolean());
	            Assert.assertEquals(jsonNode.get("order").asInt(), 56);
	            Assert.assertEquals(jsonNode.get("weight").asInt(), 75);

	            // Add more assertions for other fields

	        } catch (Exception e) {
	            e.printStackTrace();
	            Assert.fail("Failed to parse JSON response");
	        }
	    }
	    }

	 

	
		
	



