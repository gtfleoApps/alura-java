package br.com.alura.escola.aplicacao.aluno.matricular;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.Cpf;
import br.com.alura.escola.dominio.aluno.Email;

// Classe-15: Classe que representa os dados primitivos necessarios ao caso de uso MatricularAluno.
public class MatricularAlunoDTO {

    private String nomeAluno;
    private String cpfAluno;
    private String emailAluno;

    public MatricularAlunoDTO(String nomeAluno, String cpfAluno, String emailAluno) {
        this.nomeAluno = nomeAluno;
        this.cpfAluno = cpfAluno;
        this.emailAluno = emailAluno;
    }

    public Aluno criarAluno() {
        return new Aluno(new Cpf(cpfAluno), nomeAluno, new Email(emailAluno));
    }

}
