package br.com.alura.escola;

import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

// Classe-13: Exemplo de uso da aplicacao:
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
        String cpf = "123.456.789-1";
        String email = "fulano@email.com.br";

        MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria());
        matricular.executa(new MatricularAlunoDTO(nome, cpf, email));

    }
}
