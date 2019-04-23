package br.com.geval.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Gutemberg
 */
public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost/geval";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro:ConnectionFactory:getConnection = " + ex);
        }
        return null;
    }
    
}
