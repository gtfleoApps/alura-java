package br.com.alura.escola.dominio.aluno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * TelefoneTest
 */
public class TelefoneTest {

        @Test
        void naoDeveriaCriarTelefoneComDDDsInvalidos() {
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone(null, "123456789"));
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone("", "123456789"));
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone("1", "123456789"));
        }

        @Test
        void naoDeveriaCriarTelefoneComNumerosInvalidos() {
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone("61", null));
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone("61", ""));
                assertThrows(IllegalArgumentException.class,
                                () -> new Telefone("61", "123"));
        }

        @Test
        void deveriaPermitirCriarTelefoneComDDDENumeroValidos() {
                String ddd = "61";
                String numero = "123456789";
                Telefone telefone = new Telefone(ddd, numero);
                assertEquals(ddd, telefone.getDdd());
                assertEquals(numero, telefone.getNumero());
        }
}