package br.com.geval.dao;

import br.com.geval.model.Login;
import br.com.geval.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gutemberg
 */
public class LoginDAO {
    
    private Connection con;
    
    public LoginDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean validarLogin(Login login){
        try {
            String sql = "SELECT * FROM proprietario "
                    + "WHERE usuario = ? and senha = ?";
            
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, login.getUsuario());
            stmt.setString(2, login.getSenha());
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return true;
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro:LoginDAO:validarLogin = " + ex);
        }
        return false;
    }
}
