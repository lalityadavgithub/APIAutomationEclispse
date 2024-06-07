package APITesting;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class API2 {

	public static void main(String[] args) {

		RestAssured.baseURI="https://dtpapitestv1.mloyalcapture.com";
		given().log().all().header("Content-Type","Application/Json")
				.body("{\r\n"
						+ "\"UserName\":\"SFLAdmin\",\r\n"
						+ "\"Password\":\"Test123\",\r\n"
						+ "\"OAggCustomer\":\r\n"
						+ "{\r\n"
						+ "\"RecordStatus\":\"I\",\r\n"
						+ "\"DTPCustomerID\":\"0\",\r\n"
						+ "\"SFLCustomerID\":\"FSLA123883\",\r\n"
						+ "\"CustomerTitle\":\"mr\",\r\n"
						+ "\"CustomerName\":\"Lokesh\",\r\n"
						+ "\"PermanentAddress1\":\"D-2/160 hari nagar jaitpu badarpur\",\r\n"
						+ "\"PermanentAddress2\":\"sourabh vihar hari nagar\",\r\n"
						+ "\"PermanentAddress3\":\"Jaitpur badarpur etxn\",\r\n"
						+ "\"PermanentAddressLocation\":\"south delhi\",\r\n"
						+ "\"PermanentAddressCity\":\"New delhi - 44\",\r\n"
						+ "\"PermanentAddressPincode\":\"110000\",\r\n"
						+ "\"customeremail\":\"Ashish.kumar@paytmmloyal.com\",\r\n"
						+ "\"CommunicationAddress1\":\"D-2/160 hari nagar jaitpu badarpur\",\r\n"
						+ "\"CommunicationAddress2\":\"sourabh vihar hari nagar\",\r\n"
						+ "\"CommunicationAddress3\":\"Jaitpur badarpur etxn\",\r\n"
						+ "\"CommunicationAddressLocation\":\"south delhi\",\r\n"
						+ "\"CommunicationAddressCity\":\"New delhi - 44\",\r\n"
						+ "\"CommunicationAddressPincode\":\"121000\",\r\n"
						+ "\"MobileNumber\":\"9638527968\",\r\n"
						+ "\"NameOnCard\":\"lokesh\",\r\n"
						+ "\"KeyTitle\":\"mr\",\r\n"
						+ "\"KeyFirstName\":\"nhjkjglkjgljhdfgjln\",\r\n"
						+ "\"KeyDesignation\":\"Tester1\",\r\n"
						+ "\"KeyMobile\":\"9898978256\",\r\n"
						+ "\"PAN\":\"ANXPA0600L\"\r\n"
						+ "}\r\n"
						+ "}").when().post("/SFLAPI/SFL/CustomerCreation")
		.then().log().all().assertThat().statusCode(200);
	}

}
