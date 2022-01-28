package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        // Retira commit automatico do JDBC para ser controlado pela aplicacao:
        connection.setAutoCommit(false);

        String nome = "Mouse";
        String descricao = "Mouse sem fio; delete from produto";
        String sql = "Insert into produto (nome, descricao) values ('"
                + nome + "', '"
                + descricao + "')";

        // Statement stm = connection.createStatement();
        // Usar o create com esse sql pode ser catastrofico para a aplicacao:
        System.out.println(sql);

        // Regra desse exemplo: ou faz as 2 insercoes ou nao faz nada!
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "Insert into produto (nome, descricao) values (?, ?);",
                    Statement.RETURN_GENERATED_KEYS);

            // ATENCAO: seleciona o codigo -> botao direito -> refactor -> extract to
            // method:
            // stm.setString(1, nome);
            // stm.setString(2, descricao);
            // stm.execute();
            // ResultSet rst = stm.getGeneratedKeys();
            // while (rst.next()) {
            // Integer id = rst.getInt(1);
            // System.out.println("O id criado foi: " + id);
            // }

            adicionarVariavel("SmartTV", "45 Polegadas", stm);
            adicionarVariavel("Fone de Ouvido", "Fone de ouvido bluetooth", stm);
            connection.commit();

            stm.close();
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
            System.out.println("Rollback Executado!");
        }
        connection.close();

    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
        stm.setString(1, nome);
        stm.setString(2, descricao);

        boolean exceptionLigada = true;
        if (exceptionLigada && nome.equals("Fone de Ouvido")) {
            throw new RuntimeException("Não foi possível adicionar o produto! Desative 'exceptionLigada'.");
        }

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
        rst.close();
        
    }
}
