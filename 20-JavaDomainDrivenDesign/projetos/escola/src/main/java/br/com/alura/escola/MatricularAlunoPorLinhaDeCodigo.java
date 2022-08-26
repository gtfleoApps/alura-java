package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

// Classe-13: Exemplo de uso da aplicacao:
// DDD-09: Retirado do contexto academico (simula aplicacao externa)
public class MatricularAlunoPorLinhaDeCodigo {
    public static void main(String[] args) {
        /*
         * Esse codigo seria repetido por cada interface que usasse a aplicacao.
         * Para resolver, foi colocado esse Use Case na camada de aplicacao.
         * 
         * String nome = "Fulano de Tal";
         * Cpf cpf = new Cpf("123.456.789-10");
         * Email email = new Email("fulano@email.com.br");
         * Aluno aluno = new Aluno(cpf, nome, email);
         * aluno.adicionarTelefone("61", "987654321");
         * RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
         * repositorio.matricular(aluno);
         */

        String nome = "Fulano de Tal";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com.br";

        // DDD-04: Agora eh necessario o publicador para MatricularAluno:
        // MatricularAluno matricular = new MatricularAluno(new
        // RepositorioDeAlunosEmMemoria());
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
        matricular.executa(new MatricularAlunoDTO(nome, cpf, email));

        // DDD-09: Selo de aluno novato
        publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));

    }
}
