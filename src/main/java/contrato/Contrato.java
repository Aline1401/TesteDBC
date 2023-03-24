package contrato;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.response.Response;

public class Contrato {
	  @Test
	  public void ContratoValidar() {
		  when()
	        .get("SUA_URI_AQUI")
	        .then().statusCode(HttpStatus.SC_OK)
	        .body(matchesJsonSchemaInClasspath("src/test/resouces/schema.json"));
	  }
}
