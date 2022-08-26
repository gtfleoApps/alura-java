package br.com.alura.escola.gamificacao.aplicacao;

import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

// DDD-07: Gerar um selo pro novo aluno matriculado
// DDD-08: Nao usar imports que sejam de outro contexto, alem do compartilhado
// (evitar acoplamento)
public class GeraSeloAlunoNovato extends Ouvinte {

    // DDD-08: Repositorio de selos para usar em reageAo:
    private final RepositorioDeSelos repositorioDeSelos;

    public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        // DDD-07: Valida se tipo de evento eh AlunoMatriculado
        // return evento instanceof AlunoMatriculado;
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;

    }

    @Override
    protected void reageAo(Evento evento) {
        // DDD-08: Acessar CPF do Aluno a partir do Evento.
        Cpf cpfDoAluno = (Cpf) evento.informacoes().get("cpf");
        Selo novato = new Selo(cpfDoAluno, "Novato");
        repositorioDeSelos.adicionar(novato);
    }

}
