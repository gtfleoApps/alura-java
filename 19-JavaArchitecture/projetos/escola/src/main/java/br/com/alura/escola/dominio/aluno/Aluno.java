package br.com.alura.escola.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

/*
* Entidades possuem uma identidade única, enquanto VOs são considerados iguais,
* se todos os seus atributos tiverem valores iguais.
*/

// Classe-01
// A classe aluno eh uma entidade.
public class Aluno {

    // id nao eh dominio da aplicacao, mas de banco de dados
    // private Long id;

    // No dominio aluno, usa-se cpf para distinguir os alunos.
    private Cpf cpf;

    private String nome;

    // Por ter regras proprias, email deve ser uma classe
    private Email email;

    private List<Telefone> telefones = new ArrayList<>();

    private String senha;

    public Aluno(Cpf cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

}
