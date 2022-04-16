package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        // Statement stm = con.createStatement();
        // boolean resultado = stm.execute("select id, nome, descricao from produto");
        
        PreparedStatement stm = con.prepareStatement("select id, nome, descricao from produto where id <> ? ;");
        Integer idQuery = 0;
        stm.setInt(1, idQuery);
        boolean resultado = stm.execute();

        // true se houver uma lista com resultado (java.sql.ResultSet):
        System.out.println(resultado);

        ResultSet rst = stm.getResultSet();

        while (rst.next()) {
            Integer id = rst.getInt("id");
            String nome = rst.getString("nome");
            String descricao = rst.getString("descricao");

            System.out.println("Id: " + id + ", Nome: " + nome + ", Descrição: " + descricao);
        }

        stm.close();
        con.close();
    }

}
