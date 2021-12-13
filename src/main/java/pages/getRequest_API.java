package pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import baseLayer.TestBase;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class getRequest_API extends TestBase {

	public getRequest_API() throws FileNotFoundException, IOException {
		super();
		initialization();
	}
	
	public double getTempFromAPI() {
		Response response =      given().log().all()
										.queryParam("q", prop.getProperty("api_city"))
											.queryParam("appid", prop.getProperty("appid"))
												.when()
													.get(baseURI);
		
		JsonPath js = new JsonPath(response.asString()); //parsing json
		return Double.parseDouble(js.getString("main.temp"));
		
	}
}
