package br.com.geval.dao;

import br.com.geval.model.Endereco;
import br.com.geval.model.Login;
import br.com.geval.model.Proprietario;
import br.com.geval.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    public Proprietario retornaProprietario(int id){
        try {
            String sql = "SELECT * FROM proprietario WHERE id = ?";
            PreparedStatement stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                
                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("rua"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                
                Login login = new Login();
                login.setUsuario(rs.getString("usuario"));
                login.setSenha(rs.getString("senha"));
                
                Proprietario proprietario = new Proprietario();
                proprietario.setId(rs.getInt("id"));
                proprietario.setNome(rs.getString("nome"));
                proprietario.setSobrenome(rs.getString("sobrenome"));
                proprietario.setSexo(rs.getString("sexo"));
                proprietario.setTelefone(rs.getString("telefone"));
                proprietario.setEmail(rs.getString("email"));
                proprietario.setEndereco(endereco);
                proprietario.setLogin(login);
                
                return proprietario;
            }
        } catch (SQLException ex) {
            System.out.println("Erro:ProprietarioDAO:retornaProprietario = " + ex);
        }
        return null;
    }
}
