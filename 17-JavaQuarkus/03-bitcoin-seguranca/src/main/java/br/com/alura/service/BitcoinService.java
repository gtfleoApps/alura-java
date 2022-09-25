package br.com.alura.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.alura.model.Bitcoin;

// Responsavel por fazer a requisicao pra API bitcoin - Interface de conexao com a API bitcoin:
// @Path - determina o recurso da API a ser acessada pela aplicacao
// @RegisterRestClient - informa que o recurso pode ser injetado em algum recurso da aplicacao
// configKey - permite substituir o fullQualifiedName da classe (package) pelo nome atribuido (bitcoin-api, por exemplo)
@Path("/bitcoins")
@RegisterRestClient(configKey = "bitcoin-api")
public interface BitcoinService {

    // Lista de bitcoins:
    // GET - tipo de acionamento do metodo
    // Produces - resultado do metodo (um json)
    @GET 
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar();


}