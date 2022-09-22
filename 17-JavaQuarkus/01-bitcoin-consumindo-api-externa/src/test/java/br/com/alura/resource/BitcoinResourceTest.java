package br.com.alura.resource;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

// Classe04:
// 

// @QuarkusTest - define que se estah num escopo de teste
@QuarkusTest
public class BitcoinResourceTest {

	// @Test - injecao para execucao de testes
	// RestAssured - metodo usado para testar Status Code da API
	// "bitcoins" - URI definida no @Path da classe BitcoinResource
	// Obs.: Esse eh um teste de Integracao, pois valida, inclusive, a chamada da
	// API externa consumida
	@Test
	public void testarSeStatusCodeDaRequisicaoE200() {
		RestAssured
				.given()
				.when().get("bitcoins")
				.then().statusCode(200);
	}

}
