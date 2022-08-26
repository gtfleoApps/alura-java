package br.com.alura.escola.academico.dominio.aluno;

import java.time.LocalDateTime;
import java.util.Map;

import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

// DDD-02: Evento - Representa o evento de um aluno matriculado
public class AlunoMatriculado implements Evento {

    // Lembrando: final faz com que seja necessario instanciar o objeto passando a
    // os atributos no construtor!
    private final Cpf cpfDoAluno;
    private final LocalDateTime momento;

    public AlunoMatriculado(Cpf cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public Cpf getCpfDoAluno() {
        return cpfDoAluno;
    }

    // DDD-07: Novo metodo implementado em Evento.
    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    // DDD-08: Novo metodo implementado em Evento.
    // Retorna apenas o CPF do aluno
    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpfDoAluno);
    }

}
