package br.com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private String jdbcUrl = "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
    private String userDb = "root";
    private String passwordDb = "root";

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(jdbcUrl);
        comboPooledDataSource.setUser(userDb);
        comboPooledDataSource.setPassword(passwordDb);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
