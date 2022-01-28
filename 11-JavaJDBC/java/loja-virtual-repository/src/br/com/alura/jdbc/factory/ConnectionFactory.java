package br.com.alura.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;
// import java.sql.DriverManager;

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

        // Nr maximo de conexoes:
        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection recuperarConexao() throws SQLException {
        // return DriverManager.getConnection(jdbcUrl, userDb, passwordDb);
        return this.dataSource.getConnection();
    }

}
