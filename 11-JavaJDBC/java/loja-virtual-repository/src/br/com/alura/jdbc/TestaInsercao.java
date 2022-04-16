package br.com.alura.jdbc;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercao {
    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        Statement stm = connection.createStatement();

        // No caso do insert, o execute retorna falso quando nao existe registro
        // duplicado:
        boolean resultado = stm.execute("insert into produto (nome, descricao) values ('Mouse', 'Mouse sem fio');",
                Statement.RETURN_GENERATED_KEYS);
        System.out.println(resultado);

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            // Em SQL, o primeiro elemento tem indice igual a 1 (diferente do java, que eh
            // 0):
            Integer id = rst.getInt(1);
            System.out.println("O Id criado foi: " + id);
        }

        connection.close();
    }
}
