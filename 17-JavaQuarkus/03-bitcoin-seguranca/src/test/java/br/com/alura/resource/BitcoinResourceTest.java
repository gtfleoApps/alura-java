package br.com.alura.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

// @QuarkusTest - define que se estah num escopo de teste
@QuarkusTest
public class BitcoinResourceTest {
	
	// @Test - injecao para execucao de testes
	@Test
	public void testarSeStatusCodeDaRequisicaoE200() {
		RestAssured
			.given()
				.when().get("bitcoins")
					.then().statusCode(200);
	}

}
