package br.com.alura.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.Cpf;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);

    }

    @Override
    public List<Selo> selosDoAlunoDeCpf(Cpf cpf) {
        // return this.selos
        // .stream()
        // .filter(s -> s.getCpfDoAluno()
        // .collect(Collectors.toList()));
        return null;
    }

}