package br.edu.poo.m0038.config;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final Dotenv dotenv = Dotenv.load();

    public static Connection getConexao() throws SQLException {
        String url = dotenv.get("DB_URL");
        String usuario = dotenv.get("DB_USER");
        String senha = dotenv.get("DB_PASSWORD");
        return DriverManager.getConnection(url, usuario, senha);
    }
}
