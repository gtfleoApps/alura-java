package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.model.Ordem;
import br.com.alura.model.Usuario;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

    @Inject
    OrdemRepository ordemRepository;

    public void inserir(SecurityContext securityContext, Ordem ordem) {
        // Optional<Usuario> - Pode existir ou nao esse usuario
        Optional<Usuario> usuarioOptional = Usuario.findByIdOptional(ordem.getUserId());
        // Se nao existir, emite uma excecao
        Usuario usuario = usuarioOptional.orElseThrow();
        // Se usuario for diferente do usuario logado:
        if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
            throw new RuntimeException("O usuário logado é diferente do userId!");
        }
        // Persiste a ordem:
        ordem.setData(LocalDate.now());
        ordem.setStatus("ENVIADA");
        ordemRepository.persist(ordem);
    }

    public List<Ordem> listar() {
        return ordemRepository.listAll();
    }

}
