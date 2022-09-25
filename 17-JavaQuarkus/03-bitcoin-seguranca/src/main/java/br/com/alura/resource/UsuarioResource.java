package br.com.alura.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.model.Usuario;

@Path("/usuarios")
public class UsuarioResource {

    // @POST - tipo de metodo http para acionar esse metodo
    // @Transactional - JTA usado no quarkus
    // @Consume - identifica a entrada do metodo (nesse caso, um Json)
    // @PermitAll - qualquer usuario pode se cadastrar nesse endpoint
    @POST
    @Transactional
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir(Usuario usuario) {
        // persist eh um metodo estatico que estah em PanacheEntityBase
        // (herdada por Usuario, que a estende )
        // Usuario.persist(usuario);
        // adicionar eh o persist, com tratamentos para seguranca
        Usuario.adicionar(usuario);
    }

    @GET
    @RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listar() {
        return Usuario.listAll();
    }

}
