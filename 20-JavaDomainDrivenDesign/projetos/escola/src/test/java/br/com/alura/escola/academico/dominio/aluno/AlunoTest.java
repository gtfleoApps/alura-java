package br.com.alura.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.shared.dominio.Cpf;

class AlunoTest {
    private Aluno aluno;

    @BeforeEach
    void beforeEach() {
        this.aluno = new Aluno(
                new Cpf("123.456.789-10"),
                "Fulano da Silva",
                new Email("fulano@email.com"));
    }

    @Test
    void deveriaPermitirAdicionar1Telefone() {
        this.aluno.adicionarTelefone("61", "987654321");
        assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void deveriaPermitirAdicionar2Telefones() {
        this.aluno.adicionarTelefone("61", "987654321");
        this.aluno.adicionarTelefone("11", "123456789");
        assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDeveriaPermitirAdicionar3Telefones() {
        assertThrows(IllegalArgumentException.class, () -> {
            this.aluno.adicionarTelefone("61", "987654321");
            this.aluno.adicionarTelefone("11", "123456789");
            this.aluno.adicionarTelefone("83", "111222333");
        });
    }
}
