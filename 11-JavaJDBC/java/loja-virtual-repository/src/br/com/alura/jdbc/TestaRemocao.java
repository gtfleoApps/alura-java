package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        // Statement stm = connection.createStatement();
        // stm.execute("delete from produto where id > 2 ;");

        PreparedStatement stm = connection.prepareStatement("delete from produto where id > ? ;");
        Integer queryId = 2;
        stm.setInt(1, queryId);
        stm.execute();

        // Quantidade de linhas modificadas apos execucao do statement:
        Integer linhasModificadas = stm.getUpdateCount();
        System.out.println("Quantidade de linhas modificadas: " + linhasModificadas);

        stm.close();
        connection.close();

    }
}
