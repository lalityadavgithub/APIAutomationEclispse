package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseLogSpec;
import io.restassured.response.ValidatableResponseOptions;
import io.restassured.matcher.ResponseAwareMatcher;

@SuppressWarnings("unused")
public class PokeManApi {

    // Replace this with the actual API response string
    private static final String API_RESPONSE = "{ \"id\": 35, \"name\": \"clefairy\", \"base_experience\": 113, \"height\": 6, " +
            "\"is_default\": true, \"order\": 56, \"weight\": 75, \"is_hidden\": true, \"slot\": 3 }";

    @Test
    public void testPokemonId() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(API_RESPONSE);

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

