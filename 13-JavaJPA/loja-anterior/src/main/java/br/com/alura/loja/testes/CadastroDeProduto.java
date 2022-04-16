package br.com.alura.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.loja.modelo.Produto;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi Redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal("800"));

        // Interface entre Java e o BD:
        EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("loja"); //nome do persistence-unit do arquivo persistence.xml
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
    }
}
