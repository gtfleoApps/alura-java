package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

// Entidade que faz persistencia dos dados no bd (bind entre aplicacao java e o banco de dados):
// @Entity - anotação do JPA que indica que essa classe eh elegivel para o modelo do bd
/* 
Como funciona a Insercao no BD atraves dessa classe:
1. O Jsonb farah o bind do Json, proveniente de um front ou outra interface,
na entidade/objeto Usuario;
2. Com as anotacoes do JPA, o Hibernate reconhece a entidade como objeto contendo informacoes
que serao persistidas no banco de dados.
*/
@Entity
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private String username;

    private String password;

    // Obs: Por ser autogerado, o id nao precisa de setter!

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
