package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;

// Classe-14: Classe que representa caso de uso da camada de aplicacao
public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio) {
        this.repositorio = repositorio;
    }

    // Permite uso atraves de dados primitivos (DTO Data Transfer Object):
    // COMMAND - Executa uma acao
    public void executa(MatricularAlunoDTO dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);
    }

}
