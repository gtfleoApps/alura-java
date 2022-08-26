package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.Cpf;

// Classe-06:
// Builder: padrao de construcao de objetos
// Classe responsavel por criar objeto aluno
public class FabricaDeAluno {

    private Aluno aluno;

    // Quem usar a factory nao precisa criar objeto CPF ou Email para criar aluno:
    public FabricaDeAluno comNomeCpfEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return this;
    }

    public FabricaDeAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    // Retorna o aluno criado:
    public Aluno criar() {
        return this.aluno;
    }

    /*
     * Obs.: Ao retornar a propria FabricaDeAluno nos metodos, eh possivel o
     * encadeamento desses metodos, para criacao do aluno com todos os dados:
     * 
     * FabricaDeAluno fabrica = new FabricaDeAluno();
     * Aluno aluno = fabrica.comNomeCpfEmail("nome", "cpf", "email")
     * .comTelefone("ddd", "numero1")
     * .comTelefone("ddd", "numero2")
     * .comTelefone("ddd", "numero3")
     * .criar();
     */

}
