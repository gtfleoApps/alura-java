package br.com.alura.escola.academico.aplicacao.aluno.matricular;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

// Classe-14: Classe que representa caso de uso da camada de aplicacao
// DDD-02: Evento - Evento de aluno matriculado
public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    // DDD-04: Publicador de evento
    private final PublicadorDeEventos publicador;

    // public MatricularAluno(RepositorioDeAlunos repositorio) {
    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    // Permite uso atraves de dados primitivos (DTO Data Transfer Object):
    // COMMAND - Executa uma acao
    public void executa(MatricularAlunoDTO dados) {
        Aluno novo = dados.criarAluno();
        repositorio.matricular(novo);

        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        publicador.publicar(evento);
    }

}
