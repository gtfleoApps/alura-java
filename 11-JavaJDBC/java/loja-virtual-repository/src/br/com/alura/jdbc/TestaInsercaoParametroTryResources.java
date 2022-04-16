package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoParametroTryResources {
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection connection = factory.recuperarConexao()) {

            // Retira commit automatico do JDBC para ser controlado pela aplicacao:
            connection.setAutoCommit(false);

            // Regra desse exemplo: ou faz as 2 insercoes ou nao faz nada!
            try (PreparedStatement stm = connection.prepareStatement(
                    "Insert into produto (nome, descricao) values (?, ?);",
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                adicionarVariavel("SmartTV", "45 Polegadas", stm);
                adicionarVariavel("Fone de Ouvido", "Fone de ouvido bluetooth", stm);
                connection.commit();

            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                System.out.println("Rollback Executado!");
            }
        }

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        boolean exceptionLigada = true;
        if (exceptionLigada && nome.equals("Fone de Ouvido")) {
            throw new RuntimeException("Não foi possível adicionar o produto! Desative 'exceptionLigada'.");
        }

        stm.execute();

        try (ResultSet rst = stm.getGeneratedKeys()) {
            while (rst.next()) {
                Integer id = rst.getInt(1);
                System.out.println("O id criado foi: " + id);
            }
        }

    }

}
