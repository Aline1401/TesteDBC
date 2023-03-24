package dominio;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;

public class BaseTest implements Constantes {
	@BeforeClass
	
public static void setup() {
		RestAssured.baseURI=APP_BASE_URL;
		//RestAssured.port= APP_PORT;
		RestAssured.basePath= APP_BASE_PATH;
		
		ResponseSpecBuilder resBuilder= new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

}
}
