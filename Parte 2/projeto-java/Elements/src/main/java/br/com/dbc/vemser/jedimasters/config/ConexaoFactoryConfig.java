package br.com.dbc.vemser.jedimasters.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactoryConfig {
    private static final String SERVER = "localhost";
    private static final String PORT = "1521"; // Porta TCP padrão do Oracle
    private static final String DATABASE = "xe";

    // Configuração dos parâmetros de autenticação
    private static final String USER = "system";
    private static final String PASS = "oracle";
    private static final String SCHEMA = "VEM_SER";

    public static Connection recuperarConexao() throws SQLException {
        String url = "jdbc:oracle:thin:@" + SERVER + ":" + PORT + ":" + DATABASE;



        Connection con = DriverManager.getConnection(url, USER, PASS);


        con.createStatement().execute("alter session set current_schema=" + SCHEMA);

        return con;
    }
}