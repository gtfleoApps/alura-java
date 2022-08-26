package br.com.alura.escola.academico.aplicacao.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.shared.dominio.Cpf;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

// Classe-16: Teste do Use Case da camada de aplicacao:
class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        // Como envolve repositorio tambem, trata-se de teste integracao
        // MOCK: para um teste de unidade, o repositorio poderia ser mockado
        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);

        MatricularAlunoDTO dados = new MatricularAlunoDTO(
                "Fulano",
                "123.456.789-10",
                "fulano@email.com");
        useCase.executa(dados);

        Aluno encontrado = repositorio.buscarPorCpf(new Cpf("123.456.789-10"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-10", encontrado.getCpf().toString());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }
}
