package br.com.alura.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;

// Classe03:
// Responsavel por expor a aplicacao para o usuario (endPoint):
// Path - aqui, eh para chamar a aplicacao (diferente do Path em service, que eh para acionar um recurso da aplicacao)
@Path("/bitcoins")
public class BitcoinResource {

    // Aqui eh feito a injecao do service (Inject eh do CDI):
    @Inject
    @RestClient
    BitcoinService bitcoinService;

    // GET - Metodo http que o usuario vai ter que usar pra chegar nessa funcao:
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bitcoin> listar() {
        return bitcoinService.listar();
    }

}