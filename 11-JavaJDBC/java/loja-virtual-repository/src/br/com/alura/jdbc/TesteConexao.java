package br.com.alura.jdbc;
import java.sql.Connection;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) throws Exception {

        // private String url =
        // "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
        // private String user = "root";
        // private String password = "root";

        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection con = connectionFactory.recuperarConexao();

        System.out.println("Fechando conexão!!");
        System.out.println(con.toString());
        con.close();
    }
}
