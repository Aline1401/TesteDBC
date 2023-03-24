package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import dominio.BaseTest;
import dominio.Usuario;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DBCTest extends BaseTest {

	@BeforeClass
	
	public static void setup() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	}
	@Test
public void deveValidarStatusRespontaAPI() {
		
	given()
		
	.when()
		.get(APP_BASE_URL)
	.then()
		.statusCode(HttpStatus.SC_OK)
	;
	
}

@Test
public void deveIncluirUsuario() {
	Usuario usuario = new Usuario("aline", "analist");
	
	 given()
	 	.contentType(ContentType.JSON)
		.body(usuario)
	.when()
		.post(APP_BASE_PATH)
	.then()
		.statusCode(HttpStatus.SC_CREATED)
		.body("id",is(notNullValue()))
		.body("name", is("aline"))
	;
	}

@Test
public void deveValidarCampoObrigatorios() {
		
	 given()
		.body("{}")
	.when()
		.post(APP_BASE_PATH)
	.then()
		.statusCode(HttpStatus.SC_BAD_REQUEST)
	;
}
@Test
public void deveDeletarUsuario() {
		given()
		.when()
			.delete("https://reqres.in/api/users/2")
		.then()
			.statusCode(HttpStatus.SC_NO_CONTENT)
;
}

}






