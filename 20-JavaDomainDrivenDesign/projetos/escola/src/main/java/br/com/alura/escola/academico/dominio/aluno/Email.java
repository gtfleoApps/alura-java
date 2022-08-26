package br.com.alura.escola.academico.dominio.aluno;

// Classe-02
// Trata-se de um Value Object - 2 emails iguais sao o mesmo email.
public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail invalido.");
        }
        this.endereco = endereco;
    }

    public String getEmail() {
        return endereco;
    }
}