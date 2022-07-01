package br.com.alura.escola.dominio.aluno;

// Classe-03:
// Trata-se de um Value Object - 2 cpfs iguais sao o mesmo cpf.
public class Cpf {

    private String numero;

    public Cpf(String numero) {
        if (numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF invalido.");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

}
