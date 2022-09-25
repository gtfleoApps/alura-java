package br.com.alura.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

// Entidade que faz persistencia dos dados no bd (bind entre aplicacao java e o banco de dados):
// @Entity - anotação do JPA que indica que essa classe eh elegivel para o modelo do bd
/* 
Como funciona a Insercao no BD atraves dessa classe:
1. O Jsonb farah o bind do Json, proveniente de um front ou outra interface,
na entidade/objeto Usuario;
2. Com as anotacoes do JPA, o Hibernate reconhece a entidade como objeto contendo informacoes
que serao persistidas no banco de dados.
*/
// @UserDefinition - anotacao do security JPA que indica os criterios de seguranca
/* 
    Soh pode existir uma UserDefinition por sistema e a entidade deve ser uma JPA
    Usa as anotacoes @Username, @Passwor e @Roles (esses atributos devem ser Strings)
*/
@Entity
@UserDefinition
public class Usuario extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Username
    private String username;

    @Password
    private String password;

    @Roles
    private String role; // papel do usuario (seguranca)

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

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    // @JonbTransient - nao retorna o password quando o Jsonb for serializar
    // o objeto usuario para um objeto Json (ao fazer um GET).
    // Mas o metodo deve existir, para a validacao da senha pelo SecurityJpa.
    @JsonbTransient
    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getNome() {
        return nome;
    }

    // Realiza as devidas validacoes para seguranca:
    public static void adicionar(Usuario usuario) {
        usuario.password = BcryptUtil.bcryptHash(usuario.password);
        usuario.role = validarUsername(usuario.username);
        usuario.persist();
    }

    // Obs.: Regra simples, apenas para carater de aprendizagem!
    private static String validarUsername(String username) {
        if (username.equals("alura")) {
            return "admin";
        }
        return "user";
    }

}
