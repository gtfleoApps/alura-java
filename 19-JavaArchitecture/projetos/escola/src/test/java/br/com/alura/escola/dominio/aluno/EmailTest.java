package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmailTest {

        @Test
        void naoDeveriaCriarEmailComEnderecoInvalido() {
                assertThrows(IllegalArgumentException.class,
                                () -> new Email(null));
                assertThrows(IllegalArgumentException.class,
                                () -> new Email(""));
                assertThrows(IllegalArgumentException.class,
                                () -> new Email("emailsemarrobaouponto"));
        }

}
