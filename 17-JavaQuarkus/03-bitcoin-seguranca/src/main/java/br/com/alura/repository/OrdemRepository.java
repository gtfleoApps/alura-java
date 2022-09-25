package br.com.alura.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

// @ApplicationScoped - significa que a classe terah uma instancia criada,
//  que serah compartilhada para quem precisar utilizar OrdemRepository. 
//  A vantagem eh que ha apenas uma alocacao de memoria, pois havera apenas uma instancia compartilhada na aplicacao.
@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {
    
}
