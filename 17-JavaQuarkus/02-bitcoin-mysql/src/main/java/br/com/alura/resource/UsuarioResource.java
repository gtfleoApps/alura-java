package br.com.alura.resource;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {

    // @POST - tipo de metodo http para acionar esse metodo
    // @Transactional - JTA usado no quarkus
    // @Consume - identifica a entrada do metodo (nesse caso, um Json)
    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        // persist eh um metodo estatico que estah em PanacheEntityBase
        // (herdada por Usuario, que a estende )
        Usuario.persist(usuario);
    }

}
