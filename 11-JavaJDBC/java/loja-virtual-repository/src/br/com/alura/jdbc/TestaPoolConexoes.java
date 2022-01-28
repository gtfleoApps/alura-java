package br.com.alura.jdbc;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPoolConexoes {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        // Testando o numero maximo de conexoes (15) definido na ConnectionFactory :
        for (int i = 0; i < 20; i++) {
            connectionFactory.recuperarConexao();
            System.out.println("Conexão de nr.: " +i);
            connectionFactory.recuperarConexao();
        }
        // Com mais requisicoes que o numero maximo, as demais ficam na fila, esperando alguma vagar,
        // e a transacao continua no for.

        // Para verificar o que acontece no banco, acione o MySQL Command Line Client -> use loja_virtual -> show processlist;
    }
}
