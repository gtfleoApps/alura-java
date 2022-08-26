package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.Cpf;

// Classe-08:
// Dominio de aluno (independente de implementacoes de camadas acima)
public class AlunoNaoEncontrado extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(Cpf cpf) {
        super("Aluno nao encontrado com CPF: " + cpf.getNumero().toString());
    }
}
