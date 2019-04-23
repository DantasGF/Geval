package br.com.geval.dao;

import br.com.geval.model.Proprietario;
import br.com.geval.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gutemberg
 */
public class ProprietarioDAO {
    
    public Connection con;
    
    public ProprietarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean inserir(Proprietario proprietario){
        try {
            String sql = "INSERT INTO proprietario (nome, sobrenome, telefone, "
                    + "email, usuario, senha, rua, bairro, cidade, estado, sexo) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getSobrenome());
            stmt.setString(3, proprietario.getTelefone());
            stmt.setString(4, proprietario.getEmail());
            stmt.setString(5, proprietario.getLogin().getUsuario());
            stmt.setString(6, proprietario.getLogin().getSenha());
            stmt.setString(7, proprietario.getEndereco().getRua());
            stmt.setString(8, proprietario.getEndereco().getBairro());
            stmt.setString(9, proprietario.getEndereco().getCidade());
            stmt.setString(10, proprietario.getEndereco().getEstado());
            stmt.setString(11, proprietario.getSexo());
            stmt.execute();
            stmt.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro:ProprietarioDAO:inserir = " + ex);
        }
        return false;
    }
    
}
